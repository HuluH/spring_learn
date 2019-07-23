package com.test.domain;

import lombok.Data;

@Data
public class Account {
    private Integer Id;
    private String name;
    private float money;

    public Account(String name, float money) {
        this.name = name;
        this.money = money;
    }

    public Account() {
    }
}
