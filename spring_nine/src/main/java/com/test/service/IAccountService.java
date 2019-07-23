package com.test.service;

import com.test.domain.Account;

import java.util.List;

public interface IAccountService {

    /**
     * 通过id查找账户
     * @param id
     * @return
     */
    public Account findAccountById(Integer id);

    /**
     * 查找所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 新增账户
     * @param account
     */
    public void addAccount(Account account);

    /**
     * 删除账户
     * @param id
     */
    public void deleteAccount(Integer id);

    /**
     * 修改账户
     * @param account
     */
    public void updateAccount(Account account);

    public void transfer(String sourcename,String targetname,float money);
}
