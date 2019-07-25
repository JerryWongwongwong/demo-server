package com.yajun.demo.service;

import com.yajun.demo.mapper.UserMapper;
import com.yajun.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author yajun
 * @Date 2018/12/1  15:21
 */

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    public Person getUser(Integer id) {
        return userMapper.getUser(id);
    }

    /**
     * 新增用户
     * @param age
     * @param name
     * @param address
     * @return
     */
    public Boolean savePerson(Integer age, String name, String address) {
//        Person person = new Person();
//        person.setAge(age);
//        person.setName(name);
//        person.setAddress(address);
//        userMapper.savePerson(person);
        return true;
    }

    /**
     * 修改用户信息
     * @param id
     * @param age
     * @param name
     * @param address
     * @return
     */
    public Boolean updatePersonInfo(Integer id, Integer age, String name, String address) {
        if (null == id) {
            return false;
        }
//        Person person = new Person();
//        person.setId(id);
//        person.setAge(age);
//        person.setName(name);
//        person.setAddress(address);
//        userMapper.updatePersonInfo(person);
        return true;
    }

}
