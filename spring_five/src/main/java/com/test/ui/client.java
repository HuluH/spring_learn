package com.test.ui;

import com.test.service.IAccountService;
import com.test.service.impl.AccountService;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟表现层
 */
public class client {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
    }
}
