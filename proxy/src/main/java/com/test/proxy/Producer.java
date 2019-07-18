package com.test.proxy;

public class Producer implements IProducer{

    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱:" + money);
    }

    public void afterSale(float money){
        System.out.println("售后服务，并拿到钱:"+ money);
    }
}
