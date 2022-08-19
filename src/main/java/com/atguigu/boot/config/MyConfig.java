package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单例的
 * 2.配置类本身是组件
 * 3.proxyBeanMethods:代理bean的方法
 *  Full(proxyBeanMethods = true)全模式
 *  Lite(proxyBeanMethods = false)轻量级模式
 *  调成false的优点，不会检查组件是否在容器内，springboot启动较快
 *  组件依赖
 *
 *
 *  4.@Import({User.class, DBHelper.class})
 *         给容器中该自动创建出这两个类型的组件,默认组件的名字就是全类名
 *
 *  5.@ImportResource("classpath:beans.xml") //导入Spring的配置,进行生效
 */


@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false)  ///告诉我们SpringBoot这是一个配置类
@ConditionalOnMissingBean(name="tom")//当容器中没有tom组件的时候MyConfig生效
@ImportResource("classpath:beans.xml") //导入配置文件
@EnableConfigurationProperties(Car.class)
//1.开启Car的属性配置绑定功能
//2.同时能把这个Car组件自动注册到容器中
//使用场景，使用的是第三方包的组件，无法修改组件中代码，不能添加@Component
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中得物单实例对象
     * @return
     */
//    @ConditionalOnBean(name="tom") //@ConditionalOnXXXXXX条件装配:有tom组件的时候此方法生效
    @Bean  //给容器中添加组件，以方法名作为组件的id,返回类型就是组件类型, 返回的值就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan",18);
        //user组件依赖了Pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;

    }

//    @Bean("tom22")
    public Pet tomcatPet(){

        return new Pet("tomcat");
    }


}
