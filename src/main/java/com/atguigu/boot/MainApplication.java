package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 主程序类：主配置类
 * @SpringBootApplication : 这是一个SpringBoot应用
 * */
//@ComponentScan("")  指定路径扫描
@SpringBootApplication(scanBasePackages = "com.atguigu")//改变扫描包，默认是主程序的同层级目录下的都被扫描
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.atguigu.boot")
public class MainApplication {
    public static void main(String[] args) {
        //1.返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        //2.查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for(String name : beanDefinitionNames){
            System.out.println(name);
        }

        //3.从容器中获取组件
        /*Pet tom01 = run.getBean("tom" , Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);

        System.out.println("组件:"+(tom01==tom02));

        //4.com.atguigu.boot.config.MyConfig$$EnhancerBySpringCGLIB$$548f4c00@ec50f54
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法，Srpingboot总会验证
//        这个组件是否在容器中，SpringBoot总会验证这个组件是否在容器内
        User user= bean.user01();
        User user01=bean.user01();
        System.out.println(user==user01);

        User user011 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("用户的宠物"+(user011.getPet()==tom));


        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("=====");
        for(String s : beanNamesForType){
            System.out.println(s);
        }

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);*/


        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件:"+tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件:"+user01);

        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中tom22的组件:"+tom22);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");



        System.out.println("haha:"+haha);
        System.out.println("hehe:"+hehe);

    }
}
