package com.cssl.Collection;


import com.cssl.entity.Users;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cssl.service.IUsersService;

@RestController
public class UsersCollection {

    @DubboReference
    private IUsersService iUsersService;

    @GetMapping("/login")
    public Users login(Users users){
        return iUsersService.login(users);
       }



}
