package com.example.demo.Repositorys;

import com.example.demo.models.Son2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface Son2Dao extends CrudRepository<Son2, Long> {
}
