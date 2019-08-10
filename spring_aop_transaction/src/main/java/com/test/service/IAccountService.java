package com.test.service;

import com.test.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();

    Account findById(Integer id);

    Account findByName(String name);

    void addAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    void transfer(String resource,String target,float money);
}
