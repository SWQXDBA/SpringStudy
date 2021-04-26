package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Teacher_table")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TeacherId")
    private Long id;
    //targetEntity = Teacher.class可以不用
    //name设置的是这个表中外键的名字
    //referencedColumnName设置的是这个表中外键是什么
    //由于是一对多，所以说这个是体现在从表中 从从表中找到主表的主键进行映射！！！重点理解
    //两方配置了同一个外键 这边给主表一个维护从表外键的能力。？
//    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_teacher_id", referencedColumnName = "TeacherId")
    //放弃外键维护：删掉上面两行然后 @OneToMany(mappedBy = "teacher")
    //这个teacher指的是User中的teacher属性
    //一般只在一边设Eager，JPA接口默认为一对多为Lazy，多对一为Eager，但是Hibernate反向工程生成Entity时，多对一为Lazy，需要手动改为Eager。
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    总结：
//    一方查询多方，默认使用延迟加载
//    多方查询一方，默认使用立即加载
//
//    修改加载方式：
//    修改配置：将延迟加载改为立即加载
//    fetch：配置在多表映射关系的注解上
//    EAGER：立即加载
//    LAZY：延迟加载


    //如果用中间表 则不要设置mappedBy属性 具体不太清楚反正会出现一个新的表teacher_table_users
    private Set<User> users = new HashSet<>();

    @Column(name = "teachername")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
