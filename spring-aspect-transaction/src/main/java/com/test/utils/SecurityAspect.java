package com.test.utils;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component("security")
@Aspect
public class SecurityAspect implements Ordered {
    private static Logger logger = LoggerFactory.getLogger(SecurityAspect.class);

    @Override
    public int getOrder() {
        return 1;
    }

    @Pointcut(value = "execution(public* com.test.service.*.*(..))")
    public void myPointCut() {

    }

    @Before(value = "execution(public* com.test.service.*.*(..))")
    public void beforeSecurity() {
        logger.info("开始安全模块");
    }

    @After(value = "com.test.utils.SecurityAspect.myPointCut()")
    public void afterSecurity() {
        logger.info("结束安全模块");
    }
}
