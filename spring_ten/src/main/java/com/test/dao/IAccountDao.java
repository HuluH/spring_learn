package com.test.dao;

import com.test.domain.Account;

import java.util.List;

public interface IAccountDao {
    public List<Account> findAll();

    public Account findAccountByName(String name);

    public void add(Account account);

    public void delete(Integer id);

    public void update(Account account);
}