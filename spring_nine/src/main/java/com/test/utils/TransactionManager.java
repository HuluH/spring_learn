package com.test.utils;

/**
 * spring中的事务控制应该都放在service层
 * 之前都是放在dao层进行处理，此类的作用就是管理类
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void begin() {
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     * 由于线程和connection是绑定的，当连接关闭之后连接和线程仍然是在一起的
     * 当线程被归还到线程池中后，再次获取的时候获取到的线程存在连接，但是连接是关闭的，这样是错误的
     * 应该在关闭连接之后进行一个解绑工作
     */
    public void release() {
        try {
            connectionUtils.getConnection().close();
            //解绑
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
