package com.test.service.impl;

import com.test.dao.AccountDao;
import com.test.service.AccountService;
import org.aspectj.lang.annotation.AdviceName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional("transActionManager")
public class AccountServiceImpl implements AccountService {
    private Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    private AccountDao accountDao;

    @Autowired
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(Integer from, Integer to, Double money) {
        try {
            accountDao.decrMoney(from, money);
            accountDao.incrMoney(to, money);
            int a = 1 / 0;
            log.info("转账成功");
        }catch (Exception e){
            log.info("转账失败");
            throw new RuntimeException(e);
        }
    }
}
