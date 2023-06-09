package com.mx.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mx.mybatis_plus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * @author 马祥
 * @Package com.mx.mybatis_plus.mapper
 * @date 2023-03-15 23:08
 * @Copyright © 2024未来可期
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据年龄查询用户列表，分页显示
     * @param page
     * @param age
     * @return
     */
    Page<User> getPage(@Param("page") Page<User> page, @Param("age") Integer age);
}
