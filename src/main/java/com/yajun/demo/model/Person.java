package com.yajun.demo.model;

import lombok.Data;

/**
 * @Author yajun
 * @Date 2018/12/1  15:18
 */
@Data
public class Person {

    private String name;

    private Integer age;

    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


}
