package com.example.demo.Repositorys;

import com.example.demo.models.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Integer> {
    List<User> findAll();

    void save(User n);
}
