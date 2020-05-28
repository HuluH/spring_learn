package com.test.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@Data
public class DataSource {
    private String driver;
    private String url;
    private String username;
    private String password;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Bean
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
