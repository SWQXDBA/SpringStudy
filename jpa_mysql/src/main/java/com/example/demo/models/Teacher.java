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
    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
    //name设置的是这个表中外键的名字
    //referencedColumnName设置的是这个表中外键是什么
    //由于是一对多，所以说这个是体现在从表中 从从表中找到主表的主键进行映射！！！重点理解
    //两方配置了同一个外键 这边给主表一个维护从表外键的能力。？
    @JoinColumn(name = "user_teacher_id", referencedColumnName = "TeacherId")
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
