package com.test;

import com.test.domain.Account;
import com.test.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试类
 */

public class MyTest {

    @Test
    public void testFindAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (IAccountService) context.getBean("accountService");
        List<Account> list = as.finaAllAccount();
        for(Account account: list){
            System.out.println(account.toString());
        }
    }

    @Test
    public void testFindAccountById(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (IAccountService) context.getBean("accountService");
        Account account = as.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void testAddAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (IAccountService) context.getBean("accountService");
        Account account = new Account("test",1234f);
        as.addAccount(account);
    }

    @Test
    public void testUpdateAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (IAccountService) context.getBean("accountService");
        Account account = as.findAccountById(4);
        account.setMoney(5678f);
        as.updateAccount(account);
    }

    @Test
    public void testDeleteAccount(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (IAccountService) context.getBean("accountService");
        as.deleteAccount(4);
    }
}
