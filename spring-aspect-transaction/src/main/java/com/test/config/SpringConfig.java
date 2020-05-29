package com.test.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value = "com.test.*")
@EnableAspectJAutoProxy
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfig {
}
