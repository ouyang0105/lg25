package com.cssl.controller;

import com.cssl.Client.UsersClient;
import com.cssl.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class Userscontroller {

    @Autowired
    private UsersClient client;

    @RequestMapping("/login")
    private Users hello(Users users,@RequestHeader String token){
        System.out.println("hello"+token);
        return client.login(users,token);
    }

    @GetMapping("/cx")
    private String cx(@RequestParam String msg){

        return client.cx(msg);
    }

    @RequestMapping("/map")
    public Map<String,Object> map(@RequestParam Map<String,Object> map){
        return client.map(map);
    }




}
