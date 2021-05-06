package com.example.demo.Repositorys;

import com.example.demo.models.Son1;
import com.example.demo.models.Son2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Father_Son_Respsitory {
    @Autowired
    FatherDao fatherDao;
    @Autowired
    Son1Dao son1Dao;
    @Autowired
    Son2Dao son2Dao;

    public void addSon1(Son1 son1) {
        son1Dao.save(son1);
    }

    public void addSon2(Son2 son2) {
        son2Dao.save(son2);
    }

}
