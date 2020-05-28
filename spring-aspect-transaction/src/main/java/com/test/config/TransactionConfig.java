package com.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class TransactionConfig {

//    private DataSource dataSource;
//    @Autowired
//    public void setDataSource(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

    @Bean("transActionManager")
    public PlatformTransactionManager getPlatformTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
