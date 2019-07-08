package com.test.dao.impl;

import com.test.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * 持久层
 */
@Repository
public class AccoutDao implements IAccountDao {
    /**
     * 保存数据
     */
    public void saveAccount() {
        System.out.println("保存了数据1111111111");
    }
}
