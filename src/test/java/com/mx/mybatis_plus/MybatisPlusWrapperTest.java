package com.mx.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.mx.mybatis_plus.mapper.UserMapper;
import com.mx.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 马祥
 * @Package com.mx.mybatis_plus
 * @date 2023-03-21 20:46
 * @Copyright © 2024未来可期
 */
@SpringBootTest
public class MybatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;

    //组装查询
    @Test
    public void test(){
        //查询用户名包含m,年龄在18-30之间，邮箱不为null的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","m")
                .between("age",18,30)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out :: println);
    }

    //组装排序
    @Test
    public void test2(){
        //查询用户信息，按照年龄降序排序，年龄相同则按照id升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age")
                .orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out :: println);
    }
    //组装删除
    @Test
    public void test3(){
        //删除年龄大于25的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",25);
        int delete = userMapper.delete(queryWrapper);
        System.out.println("删除人数："+delete);
    }

    //修改
    @Test
    public void test4(){
        ////将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("小敏");
        int update = userMapper.update(user, queryWrapper);
        System.out.println("修改是否成功："+update);
    }

    //修改
    @Test
    public void test5(){
        //将用户名中包含有"小"并且（年龄大于20或邮箱为null）的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","小")
                .and(i->i.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setName("未来");
        int result = userMapper.update(user, queryWrapper);
        System.out.println(result > 0 ? "修改成功！" : "修改失败！");
        System.out.println("受影响的行数为：" + result);
    }

    //组装select语句
    @Test
    public void test6(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age","email");
        List<User> result = userMapper.selectList(queryWrapper);
        result.forEach(System.out :: println);
    }

    //实现子查询
    @Test
    public void test7(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id","select id from t_user where id < 100");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out :: println);
    }

    //测试UpdateWrapper
    @Test
    public void test8(){
        //将用户名中包含有"小"并且（年龄大于20或邮箱为null）的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name","来")
                .and(i->i.gt("age",20).or().isNull("email"));
        updateWrapper.set("name","杰伦").set("age",18);
        int res = userMapper.update(null, updateWrapper);
        System.out.println(res > 0 ? "修改成功" : "修改失败");
        System.out.println("成功记录："+res);
    }

    @Test
    public void test9(){
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isBlank("username"),"name",username)
                .ge(ageBegin != null,"age",ageBegin)
                .gt(ageEnd != null,"age",ageEnd);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test10(){
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(ageBegin != null,User::getAge,ageBegin)
                .gt(ageEnd != null,User::getAge,ageEnd);
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    //测试LamdaUpdateWrapper
    @Test
    public void test11(){
        //将用户名中包含有"小"并且（年龄大于20或邮箱为null）的用户信息修改
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName,"杰")
                .and(i->i.gt(User::getAge,20).or().isNull(User::getEmail));
        lambdaUpdateWrapper.set(User::getName,"伦").set(User::getAge,18);
        int res = userMapper.update(null, lambdaUpdateWrapper);
        System.out.println(res > 0 ? "修改成功" : "修改失败");
        System.out.println("成功记录："+res);
    }
}
