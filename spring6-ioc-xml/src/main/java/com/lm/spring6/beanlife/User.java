package com.lm.spring6.beanlife;

/**
 * @author ming
 * @date 2023.06.20
 * @about
 */
public class User {
    private  String name;

    public User(){
        System.out.println("1.Bean对象创建，调用无参数构造……");
    }
    // 初始化方法
    public void initMethod(){
        System.out.println("4.调用指定初始化方法");
    }
    // 销毁方法
    public void destroyMethod(){
        System.out.println("7.Bean对象的销毁");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2.设置属性值……");
        this.name = name;
    }
}
