package com.lm;

/**
 * @author ming
 * @date 2023.06.21
 * @about
 */
public class User {
    private String name;

    private int age;

    public User(){

    }

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }

    private void run(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
