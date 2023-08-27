package com.lm.spring6.ditest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ming
 * @date 2023.06.19
 * @about
 */
public class tesStudent {
    @Test
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di-test.xml");
        Student student = context.getBean("student",Student.class);
        student.study();
    }
}
