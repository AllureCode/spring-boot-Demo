package com.wang.springbootwebdemo.dao;

import com.wang.springbootwebdemo.entities.Department;
import com.wang.springbootwebdemo.entities.Employee;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import java.util.*;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;

    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"E-AA","aa@163.com",1,new Date(),new Department(101,"D-AA")));
        employees.put(1002,new Employee(1002,"E-BB","aa@163.com",1,new Date(),new Department(102,"D-BB")));
        employees.put(1003,new Employee(1003,"E-CC","aa@163.com",1,new Date(),new Department(103,"D-CC")));
        employees.put(1004,new Employee(1004,"E-DD","aa@163.com",1,new Date(),new Department(104,"D-DD")));
        employees.put(1005,new Employee(1005,"E-EE","aa@163.com",1,new Date(),new Department(105,"D-EE")));
    }
    private static Integer initId=1006;
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee get(Integer id){
        return employees.get(id);
    }
    public void delete(Integer id){
        employees.remove(id);
    }
}
