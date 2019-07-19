package com.yajun.demo.controller;

import java.math.BigDecimal;

/**
 *
 *
 * 线程重路
 * @Author yajun
 * @Date 2019/6/13  22:07
 */
public class T implements Runnable {

    private int count = 10;


    public /**synchronized*/ void run() {
        count--;
        System.out.println(Thread.currentThread().getName() +  "count = " + count);
    }


//    public static void main(String[] args) {
//        T t = new T();
//        for (int i = 0; i< 5; i++){
//            new Thread(t, "THREAD" + i).start();
//        }
//        t.run();
//    }


    public static void main(String[] args) {
        BigDecimal payAmount = new BigDecimal(6.00);
        BigDecimal payPalExchangeRate = new BigDecimal(6.5);
        BigDecimal payPalFeeRate = new BigDecimal(0.05);
        BigDecimal exchangePrice = payAmount.divide(payPalExchangeRate, 2, BigDecimal.ROUND_UP);

        BigDecimal exchangeFeePrice = exchangePrice.multiply(payPalFeeRate).setScale(2, BigDecimal.ROUND_UP);
        BigDecimal exchangePayPrice = exchangePrice.add(exchangeFeePrice);

        System.out.println(exchangePrice);
        System.out.println(exchangeFeePrice);
        System.out.println(exchangePayPrice);

    }

}
