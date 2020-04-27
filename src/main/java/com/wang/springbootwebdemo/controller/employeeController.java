package com.wang.springbootwebdemo.controller;

import com.wang.springbootwebdemo.dao.DepartmentDao;
import com.wang.springbootwebdemo.dao.EmployeeDao;
import com.wang.springbootwebdemo.entities.Department;
import com.wang.springbootwebdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author wang_sir
 */
@Controller
public class employeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    //跳转添加页面
    @GetMapping("/emp")
    public String toAddEmployee(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/addEmployee";
    }

    //添加员工信息
    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //跳转到修改页面
    @GetMapping("/emp/{id}")
    public String toEditEmployee(@PathVariable("id") String id
                                 ,Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        Employee employee = employeeDao.get(Integer.parseInt(id));
        model.addAttribute("employee", employee);
        return "emp/editEmployee";
    }
    //修改员工信息
    @PutMapping("/emp")
    public String editEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") String id){
        employeeDao.delete(Integer.parseInt(id));
        return "redirect:/emps";
    }
}
