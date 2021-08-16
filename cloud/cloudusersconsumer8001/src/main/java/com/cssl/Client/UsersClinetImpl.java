package com.cssl.Client;

import com.cssl.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Component
public class UsersClinetImpl implements UsersClient{

    @RequestMapping("/login")
    public Users login(Users users,String token){
        users.setName("服务器崩溃，请稍后重试");
        System.out.println(token);
        users.setId(0);
        users.setAge(0);
        users.setSex("机");
        return users;
    }

    @GetMapping("/cx")
    public String cx(@RequestParam String msg){

        return "服务器崩溃，访问请求被拒绝";
    }

    @RequestMapping("/map")
    public Map<String,Object> map(@RequestParam Map<String,Object> map){
        map.put("访问被拒绝","服务器崩溃");
        return map;
    }




}
