package com.lm.bean;

public interface ApplicationContext {
    // 返回Bean对象
    Object getBean(Class clazz) throws NoSuchMethodException;
}
