package com.test.cglib;

public class Producer{

    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱:" + money);
    }

    public void afterSale(float money){
        System.out.println("售后服务，并拿到钱:"+ money);
    }
}
