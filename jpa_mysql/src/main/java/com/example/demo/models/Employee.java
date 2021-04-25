package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_id")
    private Long id;
    private String Name;


    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    //配置中间表
    //name 中间表名称
    @JoinTable(name = "employee_role",
            //joinColumns 自己在中间表的外键
            joinColumns = {
                    @JoinColumn(name = "Employee_id", referencedColumnName = "Employee_id")
            },
            // inverseJoinColumns 对方在中间表的外键
            inverseJoinColumns = {@JoinColumn(name = "Role_id", referencedColumnName = "Role_id")}
    )
    private Set<Role> employeeSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
