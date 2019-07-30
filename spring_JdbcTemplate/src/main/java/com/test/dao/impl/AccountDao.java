package com.test.dao.impl;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao层的编写有两种方式
 * 一种是继承 JDBCTemplateSupport ，这种方式的配置只能使用xml配置jdbcTemplate
 * 另一种是将JDBCTemplate作为一个属性，这种方式可以使用注解的方式来配置
 */
//@Repository("accountDao")
public class AccountDao extends JdbcDaoSupport implements IAccountDao {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    public List<Account> findAll() {
        return getJdbcTemplate().query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);

        return accounts.size() <= 0 ? null : accounts.get(0);
    }

    public Account findByName(String name) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.size() == 0){
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("实例个数大于1");
        }
        return accounts.get(0);
    }

    public void update(Account account) {
        getJdbcTemplate().update("update account set name = ?,money = ? where id =?",account.getName(),account.getMoney(),account.getId());
    }
}
