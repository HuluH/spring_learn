package com.test.service.impl;

import com.test.dao.IAccountDao;
import com.test.dao.impl.AccoutDao;
import com.test.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 业务层实现
 */

/**
 * 曾经创建对象的xml文件
 * <bean id="" class="" scope="" init-method="" destory-method="">
 * <property name="" value="" ref=""></property>
 * </bean>
 * <p>
 * 对应的注解
 *      用于创建对象的注解
 *          他们的作用和xml配置文件中<bean>标签的作用是一样的
 *
 *          @Component
 *          @Controller:用于表现层
 *          @Service：用于业务层
 *          @Repository：用于持久层
 *
 *      用于注入数据的注解
 *          他们的作用和xml配置文件中的bean的字标签property标签的作用是一样的
 *          @Autowried 作用：    自动按照类型注入，只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，则注入成功
 *                              如果IOC容器中没有任何bean和要注入的变量类型匹配，则报错
 *                              若果IOC容器中有多个bean和要注入的类型匹配，则根据变量名称来选择，如果变量名称都不匹配，则报错
*           @Qualifier 作用：    在按照类注入的基础上在按照名称注入，它在给类成员注入的时候不能单独使用，
 *                     属性：    value 用于指定注入bean的id
 *          @Resource  作用：    直接按照bean的id注入，可以独立使用
 *                      属性：   name:用于指定bean的id
 *
 *           以上三个注解只能注入其他bean类型的数据，基本类型和String类型无法使用上述注解实现
 *           另外，集合类型的注入只能通过xml来实现
 *          @Value     作用：用于基本类型和String类型的注入
 *                      属性：value 用于指定数据的值，它可以使用spring的spEL
 *                           spEl的写法： ${表达式}
 *
 *      用于改变作用范围的注解
 *          他们的作用和xml配置文件中bean标签的scope属性的作用是一样的
 *          @Scope  作用：用于指定bean的作用范围
 *                  属性：value=“”  取值为singleton 和 protoType
 *
 *      和生命周期有关的注解
 *          他们的作用和bean标签的属性init-method和destory-method属性的作用是一样的
 *          @PreDestory  ： 作用：用于指定销毁方法
 *          @PostConstruct  作用：用于指定初始化方法
 */
@Component
public class AccountService implements IAccountService {
//    @Autowired
//    @Qualifier("accountDao2")
    @Resource(name="accountDao2")
    private IAccountDao accountDao;

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
