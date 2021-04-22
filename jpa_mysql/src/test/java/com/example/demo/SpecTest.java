package com.example.demo;

import com.example.demo.Repositorys.UserDao;
import com.example.demo.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

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

    @Test
    //多条件查询
    public void t2() {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> name = root.get("name");
                Path<Object> email = root.get("email");
                Predicate predicate = criteriaBuilder.equal(name, "name1");
                Predicate predicate2 = criteriaBuilder.equal(email, "email1");
                //两个条件同时成立用and
                Predicate ret = criteriaBuilder.and(predicate, predicate2);
                return ret;
            }
        };
        User user = userDao.findOne(specification).get();
        System.out.println(user);
    }

    @Test
    //模糊匹配
    public void t3() {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("name");
                Predicate predicate = criteriaBuilder.like(path.as(String.class), "%name%");
                return predicate;

            }
        };
        List<User> users = userDao.findAll(specification);
        System.out.println(users);
    }


    @Test
    //模糊匹配+排序
    public void t4() {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("name");
                Predicate predicate = criteriaBuilder.like(path.as(String.class), "%name%");
                return predicate;

            }
        };
        //framwork中的sort
        //Sort.Direction.ASC升序
        //Sort.Direction.DESC倒序
        List<User> users = userDao.findAll(specification, Sort.by(Sort.Direction.ASC, "id"));
        System.out.println(users);
    }

    @Test
    //分页查询
    public void t5() {
        Specification<User> specification = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> path = root.get("name");
                Predicate predicate = criteriaBuilder.like(path.as(String.class), "%name%");
                return predicate;
            }
        };
        //从0就是第一页开始 每页2个
        //改了 原来是new一个PageRequest然后传入参数 现在用工厂模式
        Pageable pageable = PageRequest.of(0, 2);
        Page<User> page = userDao.findAll(specification, pageable);
        System.out.println(page.getTotalElements());//打印总条数
        System.out.println(page.getTotalPages());//有几页
        List<User> users = page.getContent();//获取userList
        System.out.println(users);
        System.out.println(page.getContent());//打印一样的东西

    }
}
