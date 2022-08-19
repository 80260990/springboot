package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data       //getter  setter方法
@NoArgsConstructor  //无参构造器
@AllArgsConstructor //全参构造器
public class Pet {

    private String name;



}
