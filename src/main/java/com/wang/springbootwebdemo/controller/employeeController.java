package com.wang.springbootwebdemo.controller;

import com.wang.springbootwebdemo.dao.EmployeeDao;
import com.wang.springbootwebdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collection;

@Controller
public class employeeController {
    @Autowired
    EmployeeDao employeeDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    //跳转添加页面
    @GetMapping("/emp")
    public String addEmployee(){

        return "emp/addEmployee";
    }
}
