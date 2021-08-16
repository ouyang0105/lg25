package com.cssl.server.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.IUsersDao;
import com.cssl.entity.Users;
import com.cssl.server.IUsersServer;
import org.springframework.stereotype.Service;

@Service
public class UsersServer extends ServiceImpl<IUsersDao, Users> implements IUsersServer {

}
