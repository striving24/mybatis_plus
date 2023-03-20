package com.mx.mybatis_plus.pojo;

import lombok.*;

/**
 * @author 马祥
 * @Package com.mx.mybatis_plus.pojo
 * @date 2023-03-15 22:56
 * @Copyright © 2024未来可期
 */
@Data     //注意：@Data注解除了有参构造，其他都包含了
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
