package com.example.demo;

import com.example.demo.Repositorys.Father_Son_Respsitory;
import com.example.demo.models.Son1;
import com.example.demo.models.Son2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class jichengTest {
    @Autowired
    Father_Son_Respsitory res;

    @Test
    public void t1() {
        Son1 son1 = new Son1();
        son1.setSon1Age(18);
        son1.setName("son1_name");
        son1.setPassword("son1passw");
        son1.setSon1Age(15);


        Son2 son2 = new Son2();
        son2.setPassword("son2pass1");
        son2.setName("son2_1_name");
        son2.setSexMan(true);


        Son2 son2_2 = new Son2();
        son2.setSexMan(true);
        son2_2.setPassword("son2pass2");
        son2_2.setName("son2_2_name");
        res.addSon1(son1);
        res.addSon2(son2);
        res.addSon2(son2_2);
    }
}
