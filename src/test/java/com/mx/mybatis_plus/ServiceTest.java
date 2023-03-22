package com.mx.mybatis_plus;

import com.mx.mybatis_plus.pojo.User;
import com.mx.mybatis_plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 马祥
 * @Package com.mx.mybatis_plus
 * @date 2023-03-19 22:43
 * @Copyright © 2024未来可期
 */
@SpringBootTest
@MapperScan(basePackages = {"com.mx.mybatis_plus.mapper"})
public class ServiceTest {
    @Autowired
    private UserService userService;
    @Test
    //测试查询记录数量
    public void testGetCount() throws Exception {
        long count = userService.count();
        System.out.println("记录总数为："+count);
    }

    @Test
    /**
     * 测试批量添加数据
     */
    public void testSaveMore(){
        List<User> list = new ArrayList<>();
        for (int i = 1; i <= 10 ; i++) {
            User user = new User();
            user.setName("jay"+i);
            user.setEmail("maxiang@"+i);
            user.setAge(18+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }

    @Test
    public void testDelete(){
        boolean remove = userService.removeById(1636368091577360385L);
        System.out.println("是否删除成功：" + remove);
    }
}
