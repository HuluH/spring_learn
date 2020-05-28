package com.test.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value = "com.test.*")
@EnableTransactionManagement
@EnableAspectJAutoProxy
@PropertySource("classpath:jdbc.properties")
@Import({DataConfig.class,TransactionConfig.class})
public class SpringConfig {
}
