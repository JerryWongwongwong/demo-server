package com.yajun.demo.model;

import lombok.Data;

/**
 * @Author yajun
 * @Date 2018/12/1  15:18
 */

@Data
public class Person {

    private Integer id;
    private String name;
    private Integer age;
    private String address;


    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", age=" + age + '\'' +
                        ", addres=" + address
                ;
    }
}
