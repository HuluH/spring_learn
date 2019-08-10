package com.test.service.impl;

import com.test.dao.impl.AccountDao;
import com.test.domain.Account;
import com.test.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("accountService")
public class AccountService implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    public List<Account> findAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
        return accounts;
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }


    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Account account) {
        accountDao.deleteAccount(account);
    }

    public void transfer(String resource, String target, float money) {
        Account resource_account = accountDao.findByName(resource);
        Account target_account = accountDao.findByName(target);
        resource_account.setMoney(resource_account.getMoney() - money);
        target_account.setMoney(target_account.getMoney() + money);
        accountDao.updateAccount(resource_account);
//        int i = 1 / 0;
        accountDao.updateAccount(target_account);
    }
}
