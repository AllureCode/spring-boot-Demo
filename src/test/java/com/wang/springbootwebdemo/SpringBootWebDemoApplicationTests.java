package com.wang.springbootwebdemo;

import com.wang.springbootwebdemo.dao.EmployeeDao;
import com.wang.springbootwebdemo.entities.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class SpringBootWebDemoApplicationTests {

    @Autowired
    EmployeeDao employeeDao;
    @Test
    void contextLoads() {
        Collection<Employee> all = employeeDao.getAll();
        System.out.println(all);
    }

}
