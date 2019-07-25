package com.yajun.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author yajun
 * @Date 2018/12/1  15:18
 */
@AllArgsConstructor
@Data
public class Person {

    private Long uid;
    private String otterGameId;
    private Integer initNum = 0;


}
