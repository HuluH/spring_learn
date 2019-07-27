package com.test.factory;

import com.test.service.IAccountService;
import com.test.utils.TransactionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建AccountService的代理类
 */
public class BeanFactory {
    IAccountService accountService;

    TransactionUtils txManager;

    public void setTxManager(TransactionUtils txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public IAccountService getAccountService() {
        Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;

                        try {
                            txManager.begin();
                            rtValue = method.invoke(accountService, args);
                            txManager.commit();
                            return rtValue;
                        } catch (Exception e) {
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            txManager.release();
                        }
                    }
        });
        return accountService;
    }
}