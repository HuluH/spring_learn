package com.test.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志工具类
 */
public class Logger {
    /**
     * 用于日志打印，计划让其在切入点方法之前执行
     */
    public void printLog() {
        System.out.println("Logger类中的printLog打印日志了");
    }

    /**
     * 前置通知
     */
    public void beforeAdvice() {
        System.out.println("前置通知执行了");
    }

    /**
     * 后置通知
     */
    public void afterReturnAdvice() {
        System.out.println("后置通知执行了");
    }

    /**
     * 异常通知
     */
    public void throwingAdvice() {
        System.out.println("异常通知执行了");
    }

    /**
     * 最终通知
     */
    public void afterAdvice() {
        System.out.println("最终通知执行了");
    }

    /**
     * 环绕通知
     * 问题：
     * 当配置了环绕通知之后，切入点方法没有执行，而通知方法执行了
     * 分析：
     * 通过分析动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法的调用，而我们的环绕通知中没有
     * 解决：
     * spring框架为我们提供了一个接口， ProceedingJoinPoint，该接口有个方法 proceed（），此方法就相当于明确调用切入点方法
     * 该接口可以作为环绕通知的方法参数，在程序执行时，spring会为我们提供该接口的实现类供我们使用
     */
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object rtvalue = null;
        try {
            Object[] args = pjp.getArgs();//得到方法执行所需要的参数
            System.out.println("环绕通知打印日志---前置");
            rtvalue = pjp.proceed();//明确调用业务层方法(切入点方法)
            System.out.println("环绕通知打印日志---后置");
            return rtvalue;
        } catch (Throwable t) {
            System.out.println("环绕通知打印日志---异常");
            throw new RuntimeException(t);
        } finally {
            System.out.println("环绕通知打印日志---最终");
        }
    }
}
