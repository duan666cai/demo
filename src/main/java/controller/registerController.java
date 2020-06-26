package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller
public class registerController {
    @GetMapping("/register")
    @RequestMapping("/register")
    public String register()
    {
        return "register";
    }
    @RequestMapping("/adduser")
    public String adduser(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        map.put("msg",user);
        System.out.println(username);
        System.out.println(password);
        return "register";

    }
}
