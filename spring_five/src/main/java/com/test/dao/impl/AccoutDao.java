package com.test.dao.impl;

import com.test.dao.IAccountDao;

/**
 * 持久层
 */
public class AccoutDao implements IAccountDao {
    /**
     * 保存数据
     */
    public void saveAccount() {
        System.out.println("保存了数据");
    }
}
