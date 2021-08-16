package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.IUsersDao;
import com.cssl.entity.Users;
import org.apache.dubbo.config.annotation.DubboService;
import com.cssl.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class UsersService  implements IUsersService {

    @Autowired
    private IUsersDao iUsersDao;

    public Users login(Users users){
        System.out.println("prodvider2"+users);
        return iUsersDao.selectOne(new QueryWrapper<Users>().eq("name",users.getName()).eq("id",users.getId()));
    }


}
