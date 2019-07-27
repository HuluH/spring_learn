package com.test.utils;

/**
 * 事务管理类
 */
public class TransactionUtils {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void begin(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtils.getConnection().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionUtils.getConnection().close();
            connectionUtils.removeConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}