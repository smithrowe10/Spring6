package com.lm.spring6.beanlife;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ming
 * @date 2023.06.20
 * @about
 */
public class TestUser {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");
        context.getBean("user",User.class);
        System.out.println("6.Bean对象创建完成，可以使用");
        context.close();// 销毁对象
    }
}
