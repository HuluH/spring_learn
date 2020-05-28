package com.test.service;

import org.aspectj.lang.annotation.AdviceName;

public interface AccountService {
    /**
     * 转帐
     * @param from
     * @param to
     * @param money
     */
    public void transfer(Integer from, Integer to, Double money);
}
