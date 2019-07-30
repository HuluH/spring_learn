package com.test;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        IAccountDao accountDao = context.getBean("accountDao",IAccountDao.class);

        List<Account> list = accountDao.findAll();

        for (Account account : list){
            System.out.println(account.toString());
        }

        Account account1 = accountDao.findByName("aaaHH");

        System.out.println(account1.toString());

        account1.setName("aaa");
        accountDao.update(account1);

        Account account = accountDao.findById(1);

        System.out.println(account.toString());
    }
}
