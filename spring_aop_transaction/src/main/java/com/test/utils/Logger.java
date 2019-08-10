package com.test.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("logger")
public class Logger {

    @Pointcut("execution(* com.test.service.impl.*.*(..))")
    private void ptl() {
    }

    @Before("ptl()")
    public void before() {
        System.out.println("前置通知");
        System.out.println("开始调用方法");
    }

    @AfterThrowing("ptl()")
    public void afterthrowing() {
        System.out.println("异常通知");
    }

    @AfterReturning("ptl()")
    public void afterreturn() {
        System.out.println("后置通知");
    }

//    @Around("ptl()")
    public void around(){
        System.out.println("环绕");
    }
}