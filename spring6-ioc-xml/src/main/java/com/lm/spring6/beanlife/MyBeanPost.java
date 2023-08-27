package com.lm.spring6.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author ming
 * @date 2023.06.20
 * @about
 */
public class MyBeanPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("3.Bean后置处理器（初始化之前）");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("5.Bean后置处理器（初始化之后）");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
