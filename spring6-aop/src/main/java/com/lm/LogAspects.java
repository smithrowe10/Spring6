package com.lm;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author ming
 * @date 2023.07.01
 * @about
 */

// 切面类
@Component
@Aspect
public class LogAspects {
    // 设置切入点和通知类型
    // 前置：@Before()
    // 返回：@AfterReturning
    // 异常：@AfterThrowing
    // 后置：@After()
    // 环绕：@Around()

    @Before("execution(* com.lm.service.UserServiceImpl.*(..))")
    public void beforeMethod(){
        System.out.println("(注解方式)====方法执行前====");
    }

    @After("execution(* com.lm.service.UserServiceImpl.*(..))")
    public void afterMethod(){
        System.out.println("(注解方式)====方法执行后====");
    }

    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点;
    @Around("execution(* com.lm.service.UserServiceImpl.*(..))")
    public void aroundMethod(ProceedingJoinPoint pj) throws Throwable{
        System.out.println("环绕前");
        Signature signature = pj.getSignature(); //获得签名
        System.out.println("signature: "+signature);

        Object proceed = pj.proceed();   //执行方法
        System.out.println("环绕后");
    }

}
