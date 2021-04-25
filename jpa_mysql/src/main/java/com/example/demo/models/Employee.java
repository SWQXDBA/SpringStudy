package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_id")
    private Long id;

    private String Name;


    @ManyToMany(targetEntity = Role.class, cascade = CascadeType.ALL)
    //配置中间表
    //name 中间表名称
    @JoinTable(name = "employee_role",
            //joinColumns 自己在中间表的外键
            joinColumns = {
                    @JoinColumn(name = "Employeeid", referencedColumnName = "Employee_id")
            },
            // inverseJoinColumns 对方在中间表的外键
            inverseJoinColumns = {@JoinColumn(name = "Roleid", referencedColumnName = "Role_id")}
    )
    private Set<Role> RoleSet = new HashSet<>();

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

    public Set<Role> getRoleSet() {
        return RoleSet;
    }

    public void setRoleSet(Set<Role> employeeSet) {
        this.RoleSet = employeeSet;
    }
}
