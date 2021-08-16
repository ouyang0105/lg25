package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.IUserDao;
import com.cssl.dao.IUserMongo;
import com.cssl.entity.Users;
import com.cssl.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService extends ServiceImpl<IUserDao, Users                                                                                                                                               >  implements IUsersService {

    @Autowired
    private IUserMongo iUserMongo;

   /* @Autowired
    private MongoTemplate mongoTemplate;*/

    //condition = "#id%2==1"
    @Cacheable(value = "users",key = "#id",unless = "#result==null")
    @Override
    public Users findById(Integer id){
         return baseMapper.selectById(id);
        }

    @Override
    public Integer insert(Users users){
        baseMapper.insert(users);
        return users.getId();
    }

    @CacheEvict(value = "users",key = "#id")
    @Override
    public Integer deleteByid(Integer id){
        return baseMapper.deleteById(id);
    }



    @CachePut(value = "users",key = "#users.id")
    @Override
    public Users updateId(Users users){
        System.out.println("updateId"+users);
        baseMapper.updateById(users);
        return baseMapper.selectById(users.getId());
    }

    @Override
    public List<Users> finAll(){
        return iUserMongo.findAll();
    }

}
