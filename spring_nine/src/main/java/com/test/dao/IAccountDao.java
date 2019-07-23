package com.test.dao;

import com.test.domain.Account;

import java.util.List;

public interface IAccountDao {

    public Account findAccountById(Integer id);

    public List<Account> findAllAccount();

    public void addAccount(Account account);

    public void deleteAccount(Integer id);

    public void updateAccount(Account account);

    public Account findAccountByName(String name);
}
