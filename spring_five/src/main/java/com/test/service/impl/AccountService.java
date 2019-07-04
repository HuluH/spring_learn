package com.test.service.impl;

import com.test.dao.IAccountDao;
import com.test.dao.impl.AccoutDao;
import com.test.service.IAccountService;
import org.springframework.stereotype.Component;

/**
 * 业务层实现
 */
/**
 * 曾经创建对象的xml文件
 *  <bean id="" class="" scope="" init-method="" destory-method="">
 *      <property name="" value="" ref=""></property>
 *  </bean>
 *
 *  对应的注解
 *  用于创建对象的注解
 *          他们的作用和xml配置文件中<bean>标签的作用是一样的
 *  用于注入数据的注解
 *          他们的作用和xml配置文件中的bena的字标签property标签的作用是一样的
 *  用于改变作用范围的注解
 *          他们的作用和xml配置文件中bean标签的scope属性的作用是一样的
 *  和生命周期有关的注解
 *          他们的作用和bean标签的属性init-method和destory-method属性的作用是一样的
 */
@Component("accountService")
public class AccountService implements IAccountService {

    public void saveAccount() {
        System.out.println("ACcountService 的saveAccount方法调用了");
    }
}
