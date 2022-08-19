package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody //代表返回浏览器的是字符
@Controller*/
//JRebel  此插件是reload与devtools的restart不同
@Slf4j      //lombok提供的日志输入类log
@RestController //@ResponseBody+@RestController的结合
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String handler01(){

        log.info("请求进来了");
        return "Hello,Spring Boot 2!";
    }

    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
