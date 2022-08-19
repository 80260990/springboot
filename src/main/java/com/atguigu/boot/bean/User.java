package com.atguigu.boot.bean;

import lombok.*;

@ToString
@Data       //getter  setter方法
@NoArgsConstructor  //无参构造器
//@AllArgsConstructor //全参构造器
@EqualsAndHashCode
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Pet pet;

    public User(String name,Integer age){
        this.name=name;
        this.age=age;
    }
}
