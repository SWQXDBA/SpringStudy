package com.example.demo;

import com.example.demo.Repositorys.UserDao;
import com.example.demo.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest

class DemoApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setEmail("email" + i);
            user.setName("name" + i);
            userDao.save(user);
        }
    }

    @Test
    void modify() {
        User user = new User();
        //设置主键属性的时候进行更新
        //如果没有这个id对应的表值 则会新建一个数据
        user.setId(1L);
        user.setName("111");
        user.setEmail("eee");
        userDao.save(user);
    }

    @Test
    void delete() {
        userDao.deleteAll();
    }

    @Test
    void deleteOne() {
        User user = new User();
        //不设置主键也不能删除 要所有信息匹配
        user.setId(42L);
        user.setName("111");
        user.setEmail("eee");
        userDao.delete(user);
    }


    @Test
    void updateemail() {
        userDao.modifyEmail(50L, "50L");
    }

    @Test
    void updatename() {
        userDao.modifyNameNative(51L, "51Name");
    }

    @Test
    void findAll() {
        System.out.println(userDao.findAll());
    }


    @Test
    void findAllNative() {
        List<Object[]> list = userDao.findAllNative();
        for (Object[] o : list) {
            System.out.println(Arrays.toString(o));
        }

    }
}
