package com.lm.spring6;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ming
 * @date 2023.05.23
 * @about
 */
@Slf4j
public class TestUser {
    @Test
    public void testUserObject1(){
        log.info("执行User测试");
        // 加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取创建的对象
        User user = (User)context.getBean("user");
        System.out.println(user);

        // 调用方法进行测试
        user.hello();
    }

    // 反射创建对象
    @Test
    public void testUserObject2() throws Exception{
        // 获取类class对象
        Class clazz = Class.forName("com.lm.spring6.User");

        // 调用方法创建对象
        User user = (User)clazz.getDeclaredConstructor().newInstance();


    }
}
