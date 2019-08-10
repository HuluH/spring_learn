package com.test.dao.impl;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDao implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Account> findAll() {
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        return list;
    }

    public Account findById(Integer id) {
        List<Account> list = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public Account findByName(String name) {
        List<Account> list = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (list.size() > 1){
            System.out.println("查询结果不唯一");
            throw new RuntimeException();
        }
        return list.size() == 1 ? list.get(0) : null;
    }

    public void addAccount(Account account) {
        jdbcTemplate.update("insert into account(name,money) values (?,?)",account.getName(),account.getMoney());
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
    }

    public void deleteAccount(Account account) {
        jdbcTemplate.update("delete from account where id = ?",account.getId());
    }
}
