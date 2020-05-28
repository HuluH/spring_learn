package com.test.utils;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

//@Component("transActionAspect")
//@Aspect
public class TransActionAspect implements Ordered {
    @Override
    public int getOrder() {
        return 0;
    }

    @Pointcut(value = "execution(public* com.test.service.*.*(..))")
    public void txPointCut(){

    }

    public void test(){

    }
}
