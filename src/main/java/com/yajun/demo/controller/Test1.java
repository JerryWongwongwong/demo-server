package com.yajun.demo.controller;

/**
 * @Author yajun
 * @Date 2019/7/10  22:36
 */


/**
 * 单例模式的创建
 * 1，类构造器的私有化（private）
 * 2，类内部创建私有对象
 * 3，类内部提供公共的获取私有对象的方法
 */
public class Test1 {

    public static void main(String[] args) {
        SingletonE singleleton1 = SingletonE.getSingletonE();
        SingletonE singleleton2 = SingletonE.getSingletonE();

        System.out.println(singleleton1 == singleleton2);

        Runtime runtime = Runtime.getRuntime();
    }
}


/**
 * 饿汉式--直接创建好
 */
class SingletonE {

    /**
     * 私有化内部构造器，使外部类不能创建该类的实例
     */
    private SingletonE() {

    }

    /**内部创建实例化对象*/
    /**
     * 私有化对象，通过公共方法调用
     */
    private static SingletonE singletonE = new SingletonE();

    /**
     * 创建公共方法，只能通过类来调用，所以也要设置为statis（调用内部类创建的实例化对象）
     */
    public static SingletonE getSingletonE() {
        return singletonE;
    }

}

/**
 * 懒汉式--用的时候才创建（*可能存在线程安全问题）
 */
class SingletonL {

    private SingletonL() {

    }

    private static SingletonL singletonL = null;


    public static SingletonL getSingletonL() {
        if (null == singletonL) {
            singletonL = new SingletonL();
        }
        return singletonL;
    }

}