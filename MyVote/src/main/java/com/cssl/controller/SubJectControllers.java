package com.cssl.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cssl.entity.Options;
import com.cssl.entity.Subject;
import com.cssl.entity.Users;
import com.cssl.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
public class SubJectControllers {

        @Autowired
        ISubjectService iSubjectService;

        @RequestMapping("/select_title")
        public boolean select_title(String title){
            boolean pd=false;
            Subject su=iSubjectService.getOne(new QueryWrapper<Subject>().eq("title",title));
            if(su!=null){
                pd=true;
            }
            return pd;
        }

        @RequestMapping("/insert_subject")
        public boolean insert_subject(Subject subject){
            boolean pd=false;
         //   System.out.println(subject);
            pd=iSubjectService.insert_subject_option(subject);
            return pd;
        }

    @RequestMapping("/delete")
    public String delete(Integer sid, HttpSession session){
            Users users=(Users) session.getAttribute("ULogin");
             if (users!=null&&users.getIsAdmin()==1){
                 String pd=iSubjectService.delete(sid)+"";
                 return pd;
              }

        return JSON.toJSONString("权限不足");
    }



    @RequestMapping("/update")
    public boolean update(Subject subject,int[] oid,String[] options,String[] options1,int[] del){

            iSubjectService.update(subject,oid,options,options1,del);


         return true;
    }



}
