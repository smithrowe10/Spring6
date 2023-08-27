package com.lm.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ming
 * @date 2023.06.28
 * @about
 */

// 动态代理类
public class ProxyInvocationHandler implements InvocationHandler {
    // 被代理的对象
    private Object target;
    public void setTarget(Object target){
        this.target = target;
    }

    // 生成代理类
    public Object getProxy(){
        // 三个参数
        // 1. 加载动态生成代理类的类加载器
        // 2. 目标对象实现的所有接口的Class类型数组
        // 3 .设置代理对象实现目标对象方法的过程
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    // 处理代理实例，并返回结果
    // 参数1：代理对象
    // 参数2：代理对象需要实现的方法
    // 参数3：method方法里面的参数
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质，就是使用反射机制实现
        log(method.getName());
        Object result = method.invoke(target,args);
        return result;
    }

    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }
}
