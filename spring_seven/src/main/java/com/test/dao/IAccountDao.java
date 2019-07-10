package com.test.dao;

import com.test.domain.Account;

import java.util.List;

/**
 * 持久层
 */
public interface IAccountDao {

    /**
     * 查找所有
     * @return
     */
    List<Account>  finaAllAccount();

    /**
     * 查找一个
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 新增一个
     * @param account
     */
    void addAccount(Account account);

    /**
     * 删除一个
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 修改一个
     * @param account
     */
    void updateAccount(Account account);
}
