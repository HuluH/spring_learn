package com.test;

import com.test.config.SpringConfig;
import com.test.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

        IAccountService accountService = applicationContext.getBean("accountService",IAccountService.class);

        accountService.findAll();
        accountService.transfer("aaa","bbb",100f);
        accountService.findAll();
    }
}
