package com.yajun.demo.controller;

import com.yajun.demo.model.Person;
import com.yajun.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yajun
 * @Date 2018/12/1  15:23
 */

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/getUser")
    public Person getUser(Integer id) {

        return userService.getUser(id);
    }

    /**
     * 新增用户
     * @param age
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/saveUserInfo")
    public Boolean saveUserInfo(Integer age, String name, String address) {

        return userService.savePerson(age, name, address);
    }

    /**
     * 更新用户信息
     * @param id
     * @param age
     * @param name
     * @param address
     * @return
     */
    @RequestMapping("/updatePersonInfo")
    public Boolean updatePersonInfo(Integer id, Integer age, String name, String address) {

        return userService.updatePersonInfo(id, age, name, address);
    }

    public void aa() throws ClassNotFoundException, IllegalAccessException, InstantiationException {


        Person person = (Person) Class.forName("com.yajun.demo.model").newInstance();


        Person a = Person.class.newInstance();

    }














}
