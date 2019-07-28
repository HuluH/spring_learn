package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.test.service.IAccountService;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        IAccountService accountService = (IAccountService) context.getBean("accountService");

        accountService.saveAccount();

//        accountService.updateAccount(1);
//
//        accountService.deleteAccount();
    }
}
