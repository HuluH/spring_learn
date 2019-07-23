package com.test.service.impl;

import com.test.dao.impl.AccountDao;
import com.test.domain.Account;
import com.test.service.IAccountService;
import com.test.utils.TransactionManager;

import java.util.List;

public class AccountService implements IAccountService {

    private AccountDao accountDao;

    private TransactionManager txManager;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public Account findAccountById(Integer id) {
        try {
            //开启事务
            txManager.begin();
            //执行操作
            Account account = accountDao.findAccountById(id);
            //提交事务
            txManager.commit();
            //返回结果
            return account;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            txManager.release();
        }
    }

    public List<Account> findAll() {
        try {
            //开启事务
            txManager.begin();
            //执行操作
            List<Account> account = accountDao.findAllAccount();
            //提交事务
            txManager.commit();
            //返回结果
            return account;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            txManager.release();
        }
    }

    public void addAccount(Account account) {
        try {
            //开启事务
            txManager.begin();
            //执行操作
            accountDao.addAccount(account);            //提交事务
            txManager.commit();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            txManager.release();
        }
    }

    public void deleteAccount(Integer id) {
        try {
            //开启事务
            txManager.begin();
            //执行操作
            accountDao.deleteAccount(id);
            txManager.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放连接
            txManager.release();
        }
    }

    public void updateAccount(Account account) {
        try {
            //开启事务
            txManager.begin();
            //执行操作
            accountDao.updateAccount(account);
            txManager.commit();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            txManager.release();
        }
    }

    public void transfer(String sourcename, String targetname, float money) {
        try {
            //开启事务
            txManager.begin();
            //执行操作
            //1.查询转出账户
            Account source = accountDao.findAccountByName(sourcename);
            //2.查询转入账户
            Account target = accountDao.findAccountByName(targetname);
            //3、转出账户扣款
            source.setMoney(source.getMoney() - money);
            //4、转入账户收款
            target.setMoney(target.getMoney() + money);
            //5、更新转出账户
            accountDao.updateAccount(source);
            //6、更新转入账户
            accountDao.updateAccount(target);
            txManager.commit();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            txManager.release();
        }
    }
}
