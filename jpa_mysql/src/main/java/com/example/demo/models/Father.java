package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
//将关系改为把子类与父类使用外键关联而不是把所有字段创建在一张表上。
//默认为TABLE，此时把所有字段创建在一张表上
@Inheritance(strategy = InheritanceType.JOINED)

public class Father {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String password;
}
