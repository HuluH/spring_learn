package com.test.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * account账户类
 */
@Data
public class Account implements Serializable {
    private Integer id;
    private String name;
    private float money;

    /**
     * 此处无参构造函数是必须的，否则后边会报错
     */
    public Account() {
    }

    public Account(String name, float money) {
        this.name = name;
        this.money = money;
    }

    public Account(Integer id, String name, float money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }
}
