package com.yajun.demo.controller;

import groovy.lang.Singleton;

/**
 * @Author yajun
 * @Date 2019/7/11  20:23
 */
public class Test2 {

    public static void main(String[] args) {
        A a = new A();

        StringBuffer append = a.getAa().append("2w");
        System.out.println(a);
        System.out.println(append);
        System.out.println(A.aa);
    }
}


class A{

    final static StringBuffer aa = new StringBuffer("dfasdfas");

    final String bb;

    public A(){
        bb = "aa";
    }

    public A(String a){
        this();
        //bb = "aa";
    }

    public StringBuffer getAa(){
        System.out.println(aa);
        return aa;
    }


    public class finalAA{

        final int AA;

        public finalAA(int a){
            a ++;

            AA = a;
            System.out.println(AA);
        }
    }

}
