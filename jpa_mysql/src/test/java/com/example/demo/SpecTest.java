package com.example.demo;

import com.example.demo.Repositorys.UserDao;
import com.example.demo.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

@SpringBootTest
public class SpecTest {
    @Autowired
    private UserDao userDao;

    @Test
    //查找一个对象
    public void t1() {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //获取比较的属性
                Path<Object> userName = root.get("name");
                //equal精准匹配
                Predicate p = criteriaBuilder.equal(userName, "name1");
                return p;
            }
        };
        //Optional的get（）返回这个对象
        //直接返回Optional可以避免显示检测null
        User user = userDao.findOne(specification).get();
        System.out.println(user);
    }
}
