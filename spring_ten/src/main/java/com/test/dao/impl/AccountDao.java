package com.test.dao.impl;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import com.test.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AccountDao implements IAccountDao {

    private QueryRunner queryRunner;

    private ConnectionUtils connectionUtils;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public List<Account> findAll() {
        try {
            return queryRunner.query(connectionUtils.getConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String name) {
        try {
            List<Account> list = queryRunner.query(connectionUtils.getConnection(),"select * from account where name = ?", new BeanListHandler<Account>(Account.class), name);

            if (list == null || list.size() == 0){
                return null;
            }
            if (list.size() > 1){
                throw new RuntimeException("查询到多个账户，查询失败");
            }

            return list.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Account account) {
        try {
            queryRunner.update(connectionUtils.getConnection(),"insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) {
        try {
            queryRunner.update(connectionUtils.getConnection(),"delete from account where id = ?", id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            queryRunner.update(connectionUtils.getConnection(),"update account set name = ?,money =? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}