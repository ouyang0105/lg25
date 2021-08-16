package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.entity.Options;
import com.cssl.entity.Subject;
import com.cssl.entity.Users;
import com.cssl.entity.Vote;
import com.cssl.service.IOptionsService;
import com.cssl.service.ISubjectService;
import com.cssl.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class HTML {
    @Autowired
    ISubjectService iSubjectService;
    
    @Autowired
    IOptionsService iOptionsService;
    @Autowired
    IVoteService iVoteService;

    @RequestMapping("/login")
    public String login(){
        return  "login";
    }

    @RequestMapping("/add")
    public String add(){
        return  "add";
    }

    @RequestMapping("/quanxian")
    public String quanxian(){
        return  "quanxian";
    }


    @RequestMapping("zx")
    public String zx(HttpSession session){
        Users users=(Users) session.getAttribute("ULogin");
        List<Users> ulist=(ArrayList<Users>)session.getServletContext().getAttribute("ListUsers");
        ulist.remove(users);
        return "login";
    }

    @RequestMapping("/regist")
    public String regist(){
        return  "regist";
    }

    @RequestMapping("/votelist")
    public String votelist(Model model,
                           @RequestParam(value = "pageno",defaultValue ="1" ) Integer pageno,
                           @RequestParam(value = "pagesize",defaultValue ="3" ) Integer pagesize,
                           @RequestParam(value = "keywords",required = false,defaultValue = "") String keywords){

       QueryWrapper<Map<String,Object>> qw=new QueryWrapper<>();
       if(keywords!=null&&keywords!=""){
           qw.like("title",keywords);
       }
        model.addAttribute("keywords",keywords);
        model.addAttribute("list",iSubjectService.votelist(new Page<Map<String,Object>>(pageno,pagesize),qw));

        return "votelist";
    }


    @RequestMapping("/vote")
    public String vote(Integer sid,
                       Model model,
                       @RequestParam(value = "keywords",defaultValue = "",required = false) String keywords){
        QueryWrapper<Map<String,Object>> qw=new QueryWrapper<>();
        qw.eq("t.sid",sid);
        Page page=iSubjectService.votelist(new Page<Map<String,Object>>(1,1),qw);
        Map<String,Object> map=(Map<String,Object>)page.getRecords().get(0);

        QueryWrapper<Options> qwe=new QueryWrapper<Options>();
        qwe.like("CONTENT",keywords);
       List<Options> olist=iOptionsService.list(qwe.eq("op_sid",sid));

        model.addAttribute("map",map);
        model.addAttribute("keywords",keywords);
        model.addAttribute("olist",olist);
        return "vote";
    }

    @RequestMapping("/voteview")
    public String voteview(Integer sid,
                           @RequestParam(value = "keywords",defaultValue = "") String keywords,
                           Model model){
        QueryWrapper<Map<String,Object>> qw=new QueryWrapper<>();
        qw.eq("t.sid",sid);
        Page page=iSubjectService.votelist(new Page<Map<String,Object>>(1,1),qw);
        Map<String,Object> map=(Map<String,Object>)page.getRecords().get(0);

        QueryWrapper<Options> qwe=new QueryWrapper<Options>();
        qwe.like("CONTENT",keywords);
        List<Options> olist=iOptionsService.list(qwe.eq("op_sid",sid));


        List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();

        olist.forEach(o->{
         Map<String,Object> map1=new HashMap<>();
         map1.put("options",o);
         map1.put("count", iVoteService.count(new QueryWrapper<Vote>().eq("oid",o.getOid())));
            mapList.add(map1);
        });

        model.addAttribute("map",map);
        model.addAttribute("keywords",keywords);
        model.addAttribute("olist",mapList);
        int num=iVoteService.count(new QueryWrapper<Vote>().eq("sid",sid));
        if(num<1){
            num=1;
        }
        model.addAttribute("num",num);
        return "voteview";
    }


    @RequestMapping("/modify")
    public String modify(Integer sid,Model model){
        Subject subject=iSubjectService.getOne(new QueryWrapper<Subject>().eq("sid",sid));
        List<Options> olist=iOptionsService.list(new QueryWrapper<Options>().eq("op_sid",sid));
        model.addAttribute("subject",subject);
        model.addAttribute("olist",olist);
        return "update";
    }




}
