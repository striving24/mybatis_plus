package com.mx.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mx.mybatis_plus.mapper.UserMapper;
import com.mx.mybatis_plus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 马祥
 * @Package com.mx.mybatis_plus
 * @date 2023-03-21 23:00
 * @Copyright © 2024未来可期
 */
@SpringBootTest
public class PluginsTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testPage() throws Exception {
        //page的参数，第一个表示当前页，第二个表示每页显示的数量
        Page<User> page = new Page<>(1, 3);
        userMapper.selectPage(page,null);
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
    @Test
    public void testPage2() throws Exception {
        Page<User> page = new Page<>(1, 4);
        userMapper.getPage(page, 20);
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println(page.getPages());
        System.out.println(page.getCurrent());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
