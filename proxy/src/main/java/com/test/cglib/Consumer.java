package com.test.cglib;

import com.test.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

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
         *      基于子类的动态代理
         *          涉及到的类 ：EnHancer
         *          提供者：第三方
         *      如何创建代理对象：
         *          使用EnHancer类的 create方法
         *      创建代理对象的要求：
         *          被代理类不能是最终类
         *      create方法的使用：
         *          三个参数
         *          class：字节码    指定被代理的对象
         *          callBack：用于提供增强的代码
         *                    它是让我们写如何代理，我们一般都是写一个该接口的实现类，通常情况下是一个匿名内部类，但不是必须的
         *                     我们一般写的都是该接口的子接口实现类   MethodInterceper
         *
         */

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 被代理类对象的任何方法都会经过该方法
             * @param o
             * @param method
             * @param args
             *        以上三个参数和基于接口的动态代理的invoke方法的参数是一样的
             * @param methodProxy  ：当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
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
        cglibProducer.saleProduct(12000f);
    }
}
