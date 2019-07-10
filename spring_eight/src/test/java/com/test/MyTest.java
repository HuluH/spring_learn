package com.test;

import com.test.domain.Account;
import com.test.service.IAccountService;
import configuration.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * spring整合junit测试类
 *
 * 三步
 * 1、导入spring整合junit的jar包
 * 2、使用Junit提供的一个注解把原有的main方法替换掉，替换成spring提供的  @Runwith
 * 3、告知spring的运行器，spring的ioc创建时基于xml的还是基于注解的，并说明位置
 *       @ContextConfiguration
 *              locations : 指定xml的配置文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在的位置
 *
 *  当我们使用spring 5版本的时候，junit的版本必须为4.12及以上
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class MyTest {

    @Autowired
    private IAccountService as;
    @Test
    public void testFindAll(){
        List<Account> list = as.finaAllAccount();
        for(Account account: list){
            System.out.println(account.toString());
        }
    }

    @Test
    public void testFindAccountById(){
        Account account = as.findAccountById(2);
        System.out.println(account);
    }

    @Test
    public void testAddAccount(){
         Account account = new Account("com/test",1234f);
        as.addAccount(account);
    }

    @Test
    public void testUpdateAccount(){
        Account account = as.findAccountById(4);
        account.setMoney(5678f);
        as.updateAccount(account);
    }

    @Test
    public void testDeleteAccount(){
        as.deleteAccount(4);
    }
}
