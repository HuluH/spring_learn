package com.test.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 将connection和ThreadLoacl绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() {
        Connection conn = tl.get();
        try {
            if (conn == null) {
                conn = dataSource.getConnection();
                tl.set(conn);
            }

            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * ThreadLocal和connection解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}