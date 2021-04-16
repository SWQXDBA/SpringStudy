package com.example.demo.Repositorys;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query(value = "update User set email = ?2 where id =?1")
    @Modifying
    public void modifyEmail(Long id, String email);

    @Query(value = "update My_User_Data set name = ?2 where id =?1", nativeQuery = true)
    @Modifying
    public void modifyNameNative(Long id, String name);

    @Query(value = "select * from My_User_Data", nativeQuery = true)
    public List<Object[]> findAllNative();
}


