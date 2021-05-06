package com.example.demo.Repositorys;

import com.example.demo.models.Son1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface Son1Dao extends CrudRepository<Son1, Long> {
}
