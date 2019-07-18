package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 消费者
 */
public class Consumer {
    public static void main(String[] args) {
        final Producer producer = new Producer();

        /**
         * 动态代理：
         *      特点：字节码随用随创建，随用随加载
         *      作用：不修改源码的基础上进行增强
         *      分类：
         *          基于接口的动态代理
         *          基于类的动态代理
         *      基于接口的动态代理
         *          涉及到的类 ：Proxy
         *          提供者：JDK官方
         *      如何创建代理对象：
         *          使用Proxy类的 newProxyInstance方法
         *      创建代理对象的要求：
         *          被代理类至少实现一个接口，如果没有则不能使用
         *      newProxyInstance方法的使用：
         *          三个参数
         *          classLoader    被代理类的类加载器，固定写法
         *          class[]      被代理类的字节码数组，让代理对象和被代理对象有相同的方法，规定写法
         *          InvocationHandler：用于提供增强的代码
         *                              它是让我们写如何代理，我们一般都是写一个该接口的实现类，通常情况下是一个匿名内部类，但不是必须的
         *
         *
         */

        IProducer iProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().
                        getClassLoader(), producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何方法都会经过该方法
                     * 参数的意义
                     * @param proxy  代理对象的引用
                     * @param method 当前执行的方法
                     * @param args   当前执行方法的参数
                     * @return 和被代理对象的方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //提供增强的代码
                        Object returnValue = null;
                        //获取方法执行的参数
                        Float money = (Float) args[0];
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });
        iProducer.saleProduct(10000f);
    }
}
