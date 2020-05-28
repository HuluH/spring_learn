package com.test.javabean;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Data
//@Component
public class User{
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    private String name;
    private String password;
    private Account account;

//    @Autowired
//    private User(Account account){
//        this.account = account;
//        logger.info("User类被创建");
//    }

    @Autowired
    public void setAccount(Account account){
        this.account = account;
        logger.info("set注入Account");
    }
}
