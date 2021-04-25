package com.example.demo.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Role_id")
    private Long id;

    private String roleName;
    //    @ManyToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
//    @JoinTable(name = "employee_role",
//            //joinColumns 自己在中间表的外键
//            joinColumns = {
//                    @JoinColumn(name = "Roleid", referencedColumnName = "Role_id")
//            },
//            // inverseJoinColumns 对方在中间表的外键
//            inverseJoinColumns = {@JoinColumn(name = "Employeeid", referencedColumnName = "Employee_id")}
//    )
    @ManyToMany(mappedBy = "RoleSet")
    private Set<Employee> employeeSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleis) {
        this.roleName = roleis;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", employeeSet=" + employeeSet +
                '}';
    }
}
