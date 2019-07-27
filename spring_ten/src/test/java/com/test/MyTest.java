package com.test;

import com.test.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
@ContextConfiguration(locations = "classpath:beans.xml")
public class MyTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }
}
