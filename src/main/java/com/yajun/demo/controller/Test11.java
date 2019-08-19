package com.yajun.demo.controller;

import com.yajun.demo.model.Person;

import java.lang.reflect.Constructor;

/**
 * @Author yajun
 * @Date 2019/8/19  13:48
 */
public class Test11 {

    public static void main(String[] args) {
        try {
            Class aClass = Class.forName("com.yajun.demo.model.Person");
            Person person = (Person) aClass.newInstance();

            Constructor declaredConstructor = aClass.getDeclaredConstructor(String.class);
            System.out.println(declaredConstructor.getName());

            //Method method = aClass.getMethod();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
