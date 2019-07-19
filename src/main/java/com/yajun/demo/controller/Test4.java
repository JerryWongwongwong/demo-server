package com.yajun.demo.controller;

/**
 * 代理模式
 *
 * @Author yajun
 * @Date 2019/7/12  00:20
 */
public class Test4 {

    public static void main(String[] args) {
        Object object = new ProxyObject();
        object.action();
    }
}


interface Object {
    void action();
}

class ProxyObject implements Object {

    Object object;

    @Override
    public void action() {
        object = new ObjectImpl();
    }

    public ProxyObject() {

        object.action();

    }


}

class ObjectImpl implements Object {

    @Override
    public void action() {
        System.out.println("=======");
    }
}



