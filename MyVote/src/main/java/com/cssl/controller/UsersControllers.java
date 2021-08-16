package com.cssl.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.entity.Users;
import com.cssl.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
public class UsersControllers {

    @Autowired
    IUsersService iUsersService;




    @RequestMapping("/cx_selectone")
    public String cx_selectone(Users users, HttpSession session) throws IOException {
        ServletContext apption=session.getServletContext();
        List<Users> usersList =(List<Users>) apption.getAttribute("ListUsers");
        System.out.println("cx_selectone"+users);
       Users ULogin=iUsersService.getOne(new QueryWrapper<Users>().eq("username",users.getUserName()).eq("password",users.getPassWord()));
     //   System.out.println(ULogin);
       String pd="shibai";
       if(ULogin!=null){
         //  usersList.add(ULogin);
           if(usersList.contains(ULogin)){
               System.out.println("触发");
               pd="chongfu";
           }else{
               session.setAttribute("ULogin",ULogin);
               usersList.add(ULogin);
               pd="chenggong";
               System.out.println("cx_selectone"+usersList);
           }
       }
        System.out.println("f返回");

        return JSON.toJSONString(pd);
    }

    @RequestMapping("/selectName")
    public boolean selectName(String username){
        boolean pd=false;
       // System.out.println("selectName"+username);
        Users u=iUsersService.getOne(new QueryWrapper<Users>().eq("username",username));
        if(u!=null){
            pd=true;
        }
        return pd;
    }

    @RequestMapping("/insert_User")
    public boolean insert_User(Users users){
        users.setIsAdmin(0);
        users.setStatus(0);
        boolean pd=false;
        pd=iUsersService.save(users);
        return pd;
    }






}
