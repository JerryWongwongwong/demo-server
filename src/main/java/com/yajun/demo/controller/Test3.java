package com.yajun.demo.controller;

/**
 * 工厂模式
 * 两个接口，其中一个接口中实现另外一个接口
 *
 * @Author yajun
 * @Date 2019/7/11  23:52
 */
public class Test3 {

    public static void main(String[] args) {

        IFactoryMethod studentFactory = new StudentFactory();

        studentFactory.getIWork().doWork();

    }

}


interface IFactoryMethod {
    /**
     * IFactoryMethod这个接口方法的return 另外一个接口 || 接口的实现
     */
    IWork getIWork();
}

class StudentFactory implements IFactoryMethod {

    @Override
    public IWork getIWork() {
        return new StudentWork();
    }
}

class TeacherFactory implements IFactoryMethod {

    @Override
    public IWork getIWork() {
        return new TeacherWork();
    }
}


interface IWork {
    void doWork();
}

class StudentWork implements IWork {

    @Override
    public void doWork() {
        System.out.println("student do work!");
    }
}

class TeacherWork implements IWork {

    @Override
    public void doWork() {
        System.out.println("teacher do work!");
    }
}
