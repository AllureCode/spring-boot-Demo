package com.wang.springbootwebdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class helloController {
//    @RequestMapping("/")
//    public String sayHello(){
//        return "login";
//    }
    //向页面返回值
    @RequestMapping("/success")
    public String success(Map<String,Object> map, Model model){
        map.put("hello", "您好，spring boot");
        String [] users = new String[]{"zhangsan","李四","王五"};
        map.put("users", users);
        model.addAttribute("userT", users);
        return "success";
    }
}
