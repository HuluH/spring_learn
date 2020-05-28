package com.test.dao;

public interface AccountDao {

    /**
     * 加钱
     * @param id
     * @param money
     */
    public void incrMoney(Integer id, Double money);

    /**
     * 减钱
     * @param id
     * @param money
     */
    public void decrMoney(Integer id, Double money);

    /**
     *
     */
    public void selectForUpdate();
}
