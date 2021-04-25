package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Role_id")
    private Long id;

    private String roleis;
    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinTable(name = "employee_role",
            //joinColumns 自己在中间表的外键
            joinColumns = {
                    @JoinColumn(name = "Role_id", referencedColumnName = "Role_id")
            },
            // inverseJoinColumns 对方在中间表的外键
            inverseJoinColumns = {@JoinColumn(name = "Employee_id", referencedColumnName = "Employee_id")}
    )
    private Set<Employee> employeeSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleis() {
        return roleis;
    }

    public void setRoleis(String roleis) {
        this.roleis = roleis;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
