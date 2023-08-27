package com.lm;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ming
 * @date 2023.06.21
 * @about
 */
public class TestUser {
    // 1.获取Class对象的方式
    @Test
    public void test1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 类名.class
        Class clazz1 = User.class;
        // 对象.getClass()
        Class clazz2 = new User().getClass();
        // Class.forName("全路径")
        Class clazz3 = Class.forName("com.lm.User");

        // 实例化
        User user =(User)clazz1.getDeclaredConstructor().newInstance();
        System.out.println(user);
    }

    // 2.获取构造方法
    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = User.class;
        // 获取所有public构造方法
        Constructor[] constructors1 = clazz.getConstructors();
        // 获取所有构造方法(包括private)
        Constructor[] constructors2 = clazz.getDeclaredConstructors();
        for(Constructor c: constructors2){
            System.out.println(c.getName()+" "+ c.getParameterCount());
        }
        // 指定有参数构造创建对象
        //public
        Constructor c1 = clazz.getConstructor(String.class,int.class);
        User user1 = (User)c1.newInstance("ming",21);
        System.out.println(user1);
        // private
        Constructor c2 = clazz.getDeclaredConstructor(String.class, int.class);
        c2.setAccessible(true); // 设置允许访问
        User user2 = (User)c2.newInstance("ming",21);
        System.out.println(user2);
    }
    // 3.获取属性
    @Test
    public void test3(){
        Class clazz = User.class;
        // 获取所有public属性
        Field[] fields1 = clazz.getFields();
        // 获取所有属性（包括private）
        Field[] fields2 = clazz.getDeclaredFields();

        for(Field f:fields2){
            System.out.println(f.getName());
        }
    }
    // 4.获取方法
    @Test
    public void test4() throws Exception{
        User user = new User("ming",21);
        Class clazz = user.getClass();
        // public 方法
        Method[] methods1 = clazz.getMethods();
        for(Method m:methods1){
            if(m.getName().equals("toString")){
                m.invoke(user); // 执行 toString()方法
            }
        }

        // private
        Method[] methods2 = clazz.getDeclaredMethods();
        for(Method m:methods2){
            if(m.getName().equals("run")){
                m.setAccessible(true); // 设置允许访问
                m.invoke(user); // 执行 private run()方法
            }
        }
    }
}
