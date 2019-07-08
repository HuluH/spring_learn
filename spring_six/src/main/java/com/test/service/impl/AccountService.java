package com.test.service.impl;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import com.test.service.IAccountService;

import java.util.List;

public class AccountService implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> finaAllAccount() {
        return accountDao.finaAllAccount();
    }

    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }
}
