package com.lm;

import com.lm.service.UserService;
import com.lm.service.UserServiceImpl;
import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ming
 * @date 2023.07.01
 * @about
 */
public class TestAspects {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        userService.add();
    }
}
