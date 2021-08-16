package com.cssl.controller;

import com.cssl.Tool.RedisUtil;
import com.cssl.entity.Users;
import com.cssl.service.IUsersService;
import com.cssl.service.impl.UsersService;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private IUsersService service;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/byid")
    public Users querUsersById(Integer id){
        System.out.println("querUsersById\t\t"+id);
        return  service.findById(id);
    }

    @RequestMapping("/inid")
    public Users insert(){

        System.out.println("inid\t\t");
        Users users=new Users(90,"cxk","坤",19);
        System.out.println(users);

        return  service.findById(service.insert(users));
    }

    @RequestMapping("upid")
    public Users updateid(){
        Users users=new Users(1,"zzzx","男",12);
        return service.updateId(users);
    }

    @RequestMapping("/delete")
    public  int delete(Integer id){
        return service.deleteByid(id);
    }

    @RequestMapping("/selectAll")
    public List<Object> select(long pageno,long pagesize){

        if(!redisUtil.exists("all")){
            List<Users> ulist=service.list();
           redisUtil.lPushAll("all",ulist);
        }

        System.out.println((pageno-1)*pagesize);
        System.out.println(pagesize*pageno-1);
        return redisUtil.lRange("all",(pageno-1)*pagesize,pagesize*pageno-1);
    }
    @RequestMapping("update")
    public Users update(){
        Users users=new Users(1,"z333zx","男",12);
        service.updateById(users);
        redisUtil.set("users"+users.getId(),users);
        return (Users) redisUtil.get("users1");
    }

    @RequestMapping("insert")
    public Users insert2(){
        Users users=new Users(0,"sadejwe","男",12);
        service.insert(users);
        Users users1=service.getById(users.getId());
        redisUtil.set("users"+users.getId(),users1);
        return (Users) redisUtil.get("users"+users.getId());
    }


    @RequestMapping("delete2")
    public Integer delete2(Integer id){

        if(redisUtil.exists("users"+id)){
            redisUtil.remove("users"+id);
        }
        return  service.deleteByid(id);
    }

    @RequestMapping("/finall")
    public List<Users> finall(){
        return service.finAll();
    }

}
