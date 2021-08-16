package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.IUsersDao;
import com.cssl.entity.Users;
import com.cssl.service.IUsersService;
import org.springframework.stereotype.Controller;

@Controller
public class UsersService extends ServiceImpl<IUsersDao, Users> implements IUsersService {
}
