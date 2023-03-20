package com.mx.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mx.mybatis_plus.mapper.UserMapper;
import com.mx.mybatis_plus.pojo.User;
import com.mx.mybatis_plus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 马祥
 * @Package com.mx.mybatis_plus.service.impl
 * @date 2023-03-17 9:42
 * @Copyright © 2024未来可期
 */
@Service
/**
 * ServiceImpl实现了IService，提供了IService中基础功能的实现
 * 若ServiceImpl无法满足业务需求，则可以使用自定的UserService定义方法，并在实现类中实现
 */
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}



