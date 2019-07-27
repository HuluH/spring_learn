package com.test.service;

import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import com.test.domain.Account;

import java.util.List;

public interface IAccountService {
    public List<Account> findAll();

    public Account findAccountByName(String name);

    public void add(Account account);

    public void update(Account account);

    public void delete(Integer id);

    public void transfer(String resourceName,String targetName,float money);
}