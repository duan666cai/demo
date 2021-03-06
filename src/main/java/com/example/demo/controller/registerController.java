package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@Controller //对html页面的控制或者开发
public class registerController {
    @Autowired      //接口实例化；将usermapper的数据导入进来
    private UserMapper userMapper;

    @GetMapping("/register")   //做一种请求映射的，映射输入的地址，8080/register
    @RequestMapping("/register")        //该注解和方法一起使用，
    public String register() {
        return "register";
    }

    @RequestMapping("/login")   //HttpServletRequest request 接收前端发起的请求数据，页面到服务器
    public String login(HttpServletRequest request, Map<String,Object> map){  //map key+value的形式，服务器到页面
        //返回页面必须用string，需要拼接字符串
        String username = request.getParameter( "username");  //获取前端数据   get set
        String password = request.getParameter( "password");
        User loginuser = userMapper.login(username, password);  //接口映射
        System.out.println(loginuser);
        if (loginuser!=null) {
            map.put("msg8", "当前登录用户："+username);
            return "zhishidian";
        } else {
            map.put("msg1", "the user name or password is error"); //map.put 输出到前端
            return "login";
        }
    }

    @RequestMapping("/adduser")
    public String adduser(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        User user1 = userMapper.getuser(username);
        if (user1!=null) {
            map.put("msg1", "the user has been used,pls register again");
            return "register";
        } else {
            map.put("msg1", "register success");
            userMapper.adduser(user);
            return "login";
        }
    }

    @RequestMapping("/getuser")
    public String getuser(HttpServletRequest request, Map<String, Object> map) {
        String username = request.getParameter("username");
        User user = userMapper.getuser(username);
        if (user!= null) {
<<<<<<< HEAD
            map.put("msg2", "the user has been registered!");
            return "register";
        } else {
            map.put("msg2", "the user has not been used!");
            return "register";
        }
    }



    @RequestMapping("/deleteuser")
    public String deleteuser(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User getuser = userMapper.login(username,password);
        if (getuser != null) {
=======
            map.put("msg", "the user has been registered!");
            return "login";
        } else {
            map.put("msg", "the user has not been used!");
            return "login";
        }
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
        User loginuser = userMapper.login(username, password);
        System.out.println(loginuser);
        if (loginuser != null) {
            return "all knowledge";
        } else {
            map.put("msg2", "the user is not a legal user");
            return "login";
        }
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, Map<String,Object> map){
        String username = request.getParameter( "username");
        String password = request.getParameter( "password");
         User getuser1 = userMapper.getuser1(username, password);
        if (getuser1 != null) {
>>>>>>> 0251e74fde4b1f642d263e27f994c5089e38ba00
            userMapper.deleteuser(username);
            map.put("msg2", "the user has been deleted!");
            return "login";
        } else {
            map.put("msg2", "the user is not a legal user");
            return "login";
        }
    }

    @RequestMapping("/Update")
    public String Update(HttpServletRequest request, Map<String,Object> map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newpassword = request.getParameter("newpassword");
<<<<<<< HEAD
        User getuser = userMapper.login(username,password);
=======
        User getuser = userMapper.getuser1(username, password);
>>>>>>> 0251e74fde4b1f642d263e27f994c5089e38ba00
        if (getuser != null) {
            userMapper.updateuser(username,newpassword);
            map.put("msg3", "the user has been updated!");
            return "login";
        } else {
            map.put("msg3", "the user is not a legal user");
            return "login";
        }
    }

<<<<<<< HEAD
=======
    @RequestMapping("/zhanyuduilie")
    public String zhanyuduilie(HttpServletRequest request, Map<String,Object> map) {
        return "zhanyuduilie";
    }

    @RequestMapping("/shuzu")
    public String shuzu(HttpServletRequest request, Map<String,Object> map) {
        return "shuzu";
    }

    @RequestMapping("/xianxingbiaoyulianbiao")
    public String xianxingbiaoyulianbiao(HttpServletRequest request, Map<String,Object> map) {
        return "xianxingbiaoyulianbiao";
    }

    @RequestMapping("/shu")
    public String shu(HttpServletRequest request, Map<String,Object> map) {
        return "shu";
    }

    @RequestMapping("/tu")
    public String tu(HttpServletRequest request, Map<String,Object> map) {
        return "tu";
    }

    @RequestMapping("/chazhao")
    public String chazhao(HttpServletRequest request, Map<String,Object> map) {
        return "chazhao";
    }

    @RequestMapping("/paixu")
    public String paixu(HttpServletRequest request, Map<String,Object> map) {
        return "paixu";
    }
>>>>>>> 0251e74fde4b1f642d263e27f994c5089e38ba00
}