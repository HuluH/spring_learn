package com.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.test")
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("JdbcConfig.properties")
@EnableTransactionManagement
public class SpringConfig {
}
