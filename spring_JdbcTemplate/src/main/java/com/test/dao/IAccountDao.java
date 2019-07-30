package com.test.dao;

import com.test.domain.Account;

import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    Account findById(Integer id);

    Account findByName(String name);

    void update(Account account);

}
