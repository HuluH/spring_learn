package com.test.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Account {
    private Integer id;
    private String name;
    private float money;
}