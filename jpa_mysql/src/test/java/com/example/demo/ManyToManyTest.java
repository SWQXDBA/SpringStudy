package com.example.demo;

import com.example.demo.Repositorys.EmployeeDao;
import com.example.demo.Repositorys.RoleDao;
import com.example.demo.models.Employee;
import com.example.demo.models.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToManyTest {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void t1() {
        Role role = new Role();
        role.setRoleName("rolename1");

        Role role2 = new Role();
        role2.setRoleName("rolename2");

        Employee employee = new Employee();
        employee.setName("employeename1");


        employee.getRoleSet().add(role);
        employee.getRoleSet().add(role2);


        employeeDao.save(employee);


    }


    @Test
    public void t2() {

        Employee employee = new Employee();
        employee.setName("employeenamenew");

        Role role = roleDao.findById(1L).get();
        Role role2 = roleDao.findById(2L).get();

        System.out.println(role == null);
        System.out.println(role2);

        if (role != null)
            employee.getRoleSet().add(role);
        if (role2 != null)
            employee.getRoleSet().add(role2);
        employeeDao.save(employee);


    }

    @Test
    public void deleteOneEmployee() {
        Employee employee = employeeDao.findById(1L).get();
        employeeDao.delete(employee);
    }

    //对象导航查询
    @Test
    public void ObjetQueryTest() {
        Employee employee = employeeDao.findById(1L).get();
        employeeDao.delete(employee);
    }
}
