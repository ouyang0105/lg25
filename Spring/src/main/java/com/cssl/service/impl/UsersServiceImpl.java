package com.cssl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cssl.dao.UsersDao;
import com.cssl.pojo.Users;
import com.cssl.service.UsersService;

@Transactional
@Service
public class UsersServiceImpl implements UsersService {
			

	@Autowired
	private UsersDao udao;	


	@Override
	public boolean saveUsers(Users user) {
		
		if(udao.insert(user)>0) {			
			return true;			
		}
			
		return false;
	}


	@Override
	public int removeById(int id) {
		System.out.println("UsersServiceImpl removeById...");
		return 0;
	}

}
