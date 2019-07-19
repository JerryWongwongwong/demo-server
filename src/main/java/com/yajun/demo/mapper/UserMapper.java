package com.yajun.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yajun.demo.model.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @Author yajun
 * @Date 2018/12/1  15:20
 */

@Repository
public interface UserMapper extends BaseMapper<Person> {

    @Select("SELECT * FROM Person WHERE id = #{id}")
    Person getUser(Integer id);

    @Insert("INSERT INTO `Person`(`name`,`age`,`address`) VALUES (#{name},#{age},#{address})")
    void savePerson(Person person);

    @Update("UPDATE `Person` SET `name`=#{name},`age`=#{age},`address`=#{address} WHERE `id`=#{id}")
    void updatePersonInfo(Person person);


}
