package com.cssl.dao;

import com.cssl.entity.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface IUserMongo extends MongoRepository<Users,Integer> {

    public List<Users> findByUsername(String username);
}
