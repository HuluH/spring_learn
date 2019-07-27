package com.test.service.impl;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import com.test.service.IAccountService;

import java.util.List;

public class AccountService implements IAccountService {

    IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findAccountByName(String name) {
        return accountDao.findAccountByName(name);
    }

    public void add(Account account) {
        accountDao.add(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);

    }

    public void transfer(String resourceName, String targetName, float money) {
        Account resource = accountDao.findAccountByName(resourceName);
        Account target = accountDao.findAccountByName(targetName);
        resource.setMoney(resource.getMoney() - 100);
        target.setMoney(target.getMoney() + 100);
        accountDao.update(resource);
        accountDao.update(target);
    }
}