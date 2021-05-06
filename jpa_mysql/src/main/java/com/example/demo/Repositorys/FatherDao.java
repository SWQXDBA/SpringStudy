package com.example.demo.Repositorys;

import com.example.demo.models.Father;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FatherDao extends CrudRepository<Father, Long> {
}
