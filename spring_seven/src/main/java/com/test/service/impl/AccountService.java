package com.test.service.impl;

import com.test.dao.IAccountDao;
import com.test.domain.Account;
import com.test.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

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
