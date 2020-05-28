package com.test.dao.impl;

import com.test.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Autowired
    public void setMyJdbcTemplate(JdbcTemplate jdbcTemplate){
        super.setJdbcTemplate(jdbcTemplate);
    }

    public void incrMoney(Integer id, Double money) {
        getJdbcTemplate().update("update account set money = money + ? where id = ?", money, id);
    }

    public void decrMoney(Integer id, Double money) {
        getJdbcTemplate().update("update account set money = money - ? where id = ?", money, id);
    }

    public void selectForUpdate() {
    }
}
