package com.lm;

import com.lm.proxy.ProxyInvocationHandler;
import com.lm.service.UserService;
import com.lm.service.UserServiceImpl;

/**
 * @author ming
 * @date 2023.06.29
 * @about
 */

// 动态代理客户端（测试）
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService); //设置要代理的对象

        //动态生成代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.query();
        proxy.add();
    }
}
