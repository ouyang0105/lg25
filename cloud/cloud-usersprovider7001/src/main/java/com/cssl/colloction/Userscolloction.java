package com.cssl.colloction;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.entity.Users;
import com.cssl.server.IUsersServer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Userscolloction {

    @Autowired
    private IUsersServer server;


    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/hello")
    public Users login(Users users,@RequestHeader String token){

        return server.getOne(new QueryWrapper<Users>().eq("name",users.getName()).eq("id",users.getId()));
    }


    public Users fallback(Users users, String token){
        users.setId(0);
        users.setName("产生了，错误");
        System.out.println("fallback错误异常");
        return users;
    }



    @PostMapping("/cx")
    public String cx(String msg){
        int a=1/0;
        return "Userscolloction"+msg;
    }

    @PostMapping("/map")
    public Map<String,Object> map(@RequestParam Map<String,Object> map){
        map.put("name","欧阳");
        map.put("sb","彭易");
        return map;
    }
}
