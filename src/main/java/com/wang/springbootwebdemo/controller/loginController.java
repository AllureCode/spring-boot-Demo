package com.wang.springbootwebdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class loginController {

    @RequestMapping("/login")
//    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password")String password,
                        HttpSession session, Map<String,Object> map){
        if (username.equals("admin") && password.equals("admin")){
            session.setAttribute("user", username);
            //避免重复提交 使用重定向
            return "redirect:/main.html";
        }else {
            map.put("msg", "用户名或密码错误");
            return "login";
        }

    }
}
