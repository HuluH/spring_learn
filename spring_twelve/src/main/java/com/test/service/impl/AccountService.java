package com.test.service.impl;

import com.test.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountService implements IAccountService {
    public void saveAccount() {
        System.out.println("执行了AccountService的saveAccount方法");
        int i = 1/0;
    }

    public void updateAccount(int i) {
        System.out.println("执行了AccountService的updateAccount方法");
    }

    public int deleteAccount() {
        System.out.println("执行了AccountService的deleteAccount方法");
        return 0;
    }
}
