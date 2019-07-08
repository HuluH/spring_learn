package com.test.dao.impl;

import com.test.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao2 implements IAccountDao {
    /**
     * 保存数据
     */
    public void saveAccount() {
        System.out.println("保存了数据222222222");
    }
}
