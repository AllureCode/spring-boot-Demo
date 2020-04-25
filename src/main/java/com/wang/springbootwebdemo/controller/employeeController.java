package com.wang.springbootwebdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class employeeController {
    @GetMapping("/emps")
    public String list(){

        return "emp/list";
    }

    //跳转添加页面
    @GetMapping("/emp")
    public String addEmployee(){
        return "emp/addEmployee";
    }
}
