package com.atguigu.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件才会拥有SpringBoot提供的强大功能
 *
 */
/*@Component  //把Car添加进容器中
@ConfigurationProperties(prefix = "mycar")*/

@ToString
@Data
@NoArgsConstructor  //无参构造器
@AllArgsConstructor //全参构造器
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;
    private Integer price;


}
