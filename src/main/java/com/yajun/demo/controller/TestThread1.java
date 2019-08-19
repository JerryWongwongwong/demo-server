package com.yajun.demo.controller;

/**
 * @Author yajun
 * @Date 2019/8/8  21:04
 */
public class TestThread1 {
    public static void main(String[] args) {


        Thread1 thread1 = new Thread1();
        Thread1 thread2 = new Thread1();
        Thread1 thread3 = new Thread1();

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");
        thread1.start();
        thread2.start();
        thread3.start();


    }
}


class Thread1 extends Thread {

    static int i = 100;

    @Override
    public void run() {

        while (true) {
            if (i > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i--);
            } else {
                break;
            }
        }


    }
}