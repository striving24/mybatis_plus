package com.mx.mybatis_plus;

import com.mx.mybatis_plus.mapper.UserMapper;
import com.mx.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author 马祥
 * @Package com.mx.mybatis_plus
 * @date 2023-03-15 23:10
 * @Copyright © 2024未来可期
 */
@SpringBootTest
public class MybatisPlusTest {
    @Resource
    private UserMapper userMapper;
    /**
     * 测试查询所有数据
     */
    @Test
    void testSelectList(){
        //通过条件构造器查询一个list集合，若没有条件则置为null
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out :: println);
    }

    /**
     * 测试插入一条数据
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setName("安康读书");
        user.setAge(18);
        user.setEmail("sikufegh");
        int res = userMapper.insert(user);
        System.out.println(user.getId());
    }

    /**
     * 根据ID删除一条数据
     */
    @Test
    public void testDelete(){
        int res = userMapper.deleteById(187361835L);
        System.out.println(res);
    }

    /**
     * 根据ID批量删除数据
     */
    @Test
    public void testDeleteBatchIds(){
        List<Long> list = Arrays.asList(6L, 7L, 8L);
        int res = userMapper.deleteBatchIds(list);
        System.out.println(res);
    }

    /**
     * 根据Map条件删除一条数据
     */
    @Test
    public void testDeleteByMap(){
        HashMap<String, Object> user = new HashMap<>();
        user.put("name","萨迦");
        user.put("age",18);
        int res = userMapper.deleteByMap(user);
        System.out.println(res > 0 ? "删除成功" : "删除失败");
        System.out.println(res);
    }

    /**
     * 根据ID修改数据
     */
    @Test
    public void testUpdateByID(){
        User user = new User();
        user.setId(5L);
        user.setName("maxiang");
        user.setAge(18);
        user.setEmail("2957958973@qq.com");
        int res = userMapper.updateById(user);
        System.out.println(res > 0 ? "修改成功" : "修改失败");
        System.out.println(res);
    }

    /**
     * 根据ID查询信息
     */
    @Test
    public void testSelectByID(){
        User res = userMapper.selectById(1L);
        System.out.println(res);
    }
    /**
     * 根据多个ID查询信息
     */
    @Test
    public void testSelectByIDs(){
        List<Long> list = Arrays.asList(1L, 2L, 3L, 4L);
        List<User> users = userMapper.selectBatchIds(list);
        System.out.println(users);
    }

    /**
     * 根据Map条件查询信息
     */
    @Test
    public void testSelectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("age",18);
        List<User> res = userMapper.selectByMap(map);
        System.out.println(res);
    }

    /**
     * 查询所有用户信息
     */
    @Test
    public void testSelectList1(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out :: println);
    }
}
