package com.test.javabean;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Data
//@Component
public class Account {
    private static final Logger logger = LoggerFactory.getLogger(Account.class);
    private Account(){
        logger.info("Account类被创建");
    }
    @Autowired
    private User user;
    private BigDecimal money;
}
