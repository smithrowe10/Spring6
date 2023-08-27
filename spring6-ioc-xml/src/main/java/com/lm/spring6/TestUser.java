package com.lm.spring6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ming
 * @date 2023.05.24
 * @about
 */
public class TestUser {
    public static void main(String[] args) {

        // 1.根据id获取Bean
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user1 = (User)context.getBean("user");
        System.out.println("根据id获取Bean:"+user1);

        //2.根据类型获取Bean
        User user2 = context.getBean(User.class);
        System.out.println("根据类型获取Bean:"+user2);

        //3.根据id和类型获取Bean
        User user3 = context.getBean("user", User.class);
        System.out.println("根据id和类型获取Bean:"+user3);
    }
}
