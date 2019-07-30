package com.test.utils;

import com.test.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JDBCTemplateUtils {

    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public List<Account> findAll() {
        List<Account> accounts = jt.query("select * from Account", new BeanPropertyRowMapper<Account>(Account.class));
        return accounts;
    }
}

