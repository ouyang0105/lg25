package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.entity.Users;
import com.cssl.entity.Vote;
import com.cssl.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@ResponseBody
public class VoteControllers {

    @Autowired
    IVoteService iVoteService;

    @RequestMapping("/selecTouPiao")
    public boolean selecTouPiao(Integer sid, HttpSession session){

        Users users=(Users) session.getAttribute("ULogin");
        System.out.println(users);
        boolean pd=false;
        List<Vote> list=iVoteService.list(new QueryWrapper<Vote>().eq("sid",sid).eq("userid",users.getUserId()));
        if(list!=null&&list.size()>0){
            pd=true;
        }
        return pd;
    }

    @RequestMapping("/insertVote")
    public boolean insertVote(Vote vote,HttpSession session,int[] oid){
        boolean bool=false;
        Users users=(Users) session.getAttribute("ULogin");
        System.out.println(users);
        vote.setUserId(users.getUserId());
        System.out.println(vote);
        List<Vote> vlist=new ArrayList<Vote>();
      //  vlist.add(vote);
        for(int o:oid){
            vlist.add(new Vote(0, users.getUserId(), vote.getSid(),o));
        }
        bool=iVoteService.saveBatch(vlist);
        return bool;
    }
}
