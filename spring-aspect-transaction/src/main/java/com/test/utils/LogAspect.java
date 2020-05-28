package com.test.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component("logAspect")
@Aspect
public class LogAspect implements Ordered {

    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around(value = "execution(public* com.test.service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("开始日志模块");
        Object object = joinPoint.proceed();
        logger.info("结束日志模块");
        return object;
    }

    public int getOrder() {
        return 0;
    }
}
