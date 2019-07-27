package com.test.domain;

import lombok.Data;

@Data
public class Account {
    private Integer id;
    private String name;
    private float money;

    public Account() {
    }
}