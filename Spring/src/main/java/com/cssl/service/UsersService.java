package com.cssl.service;

import com.cssl.pojo.Users;

public interface UsersService {
	
	public boolean saveUsers(Users user);
	
	public int removeById(int id);

}
