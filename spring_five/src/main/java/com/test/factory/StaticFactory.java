package com.test.factory;

import com.test.service.IAccountService;
import com.test.service.impl.AccountService;

public class StaticFactory {
    public static IAccountService getAccountService(){
            return new AccountService();
    }
}
