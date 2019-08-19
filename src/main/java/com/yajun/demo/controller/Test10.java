package com.yajun.demo.controller;

import com.yajun.demo.model.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @Author yajun
 * @Date 2019/8/19  09:54
 */
public class Test10 {

    public static void main(String[] args) {
        Person person = new Person();
        String name = person.getClass().getName();
        System.out.println(name);


        Class personClass = Person.class;
        System.out.println(personClass);


        try {
            //得到class对象
            Class pClass = Class.forName("com.yajun.demo.model.Person");

            //后去构造器
            Constructor constructor = pClass.getConstructor(String.class, Integer.class);
            //实例化
            Person per = (Person) constructor.newInstance("张三", 4);
            System.out.println("===Person实例化===");
            System.out.println(per);

            pClass.getDeclaredConstructor(String.class);

            //获取所有的构造器
            pClass.getConstructors();
            pClass.getDeclaredConstructor();

            System.out.println("===public===");
            Field[] fields = pClass.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            System.out.println("===private===");
            Field[] declaredFields = pClass.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println(field);
            }

            Field name1 = pClass.getField("age");
            System.out.println(name1);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }


}
