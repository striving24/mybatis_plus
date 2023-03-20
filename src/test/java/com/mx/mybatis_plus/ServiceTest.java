package com.mx.mybatis_plus;

import com.mx.mybatis_plus.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
