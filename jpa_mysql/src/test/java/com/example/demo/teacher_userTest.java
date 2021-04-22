package com.example.demo;

import com.example.demo.Repositorys.TeacherDao;
import com.example.demo.Repositorys.UserDao;
import com.example.demo.models.Teacher;
import com.example.demo.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class teacher_userTest {
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void t1() {

        Teacher teacher = new Teacher();
        teacher.setName("老师1");
        User user = new User();
        user.setEmail("em");
        user.setName("user1");

        teacher.getUsers().add(user);
        //一对多的时候 应当先保存many的对象
        //@OneToMany里面的cascade默认是lazy，但是在数据库里保存数据的时候，没有手动保存many的一方，就会出错，应该先保存，many的一方，才能保存one的一方，如果把cascade设置成为all。这样就不会有问题了。
        //出现这个错误的原因是在保存该对象前，发现该对象包含有其他空的对象。
        //自己理解::在保存一的一方时 还要把多的一方的外键设置为自己 此时如果多的一方还没有保存就无法更新设置
        userDao.save(user);
        teacherDao.save(teacher);
    }

    @Test
    public void delete() {
        userDao.deleteAll();
        teacherDao.deleteAll();
    }
}
