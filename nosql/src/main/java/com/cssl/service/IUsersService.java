package com.cssl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.entity.Users;

import java.util.List;

public interface IUsersService extends IService<Users> {
    public Users findById(Integer id);
    public Users updateId(Users users);
    public Integer insert(Users users);
    public Integer deleteByid(Integer id);
    public List<Users> finAll();
}
