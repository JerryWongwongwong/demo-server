package com.yajun.demo;

import com.yajun.demo.mapper.UserMapper;
import com.yajun.demo.service.IDCardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author yajun
 * @Date 2019/4/11  16:47
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IDCardService idCardService;


    @Test
    public void testSelect() {

        userMapper.selectList(null);

        System.out.println();

    }


    @Test
    public void testIDCard() {

        String idCard = "412726199710031276";

        idCardService.checkIDNo(idCard);



    }






}
