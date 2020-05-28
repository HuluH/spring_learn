package com.test.tx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class MyTrasnAction {

    private static Logger logger = LoggerFactory.getLogger(MyTrasnAction.class);

    private DataSourceTransactionManager transactionManager;
}
