package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.entity.Dept;
import com.cssl.entity.Emp;
import com.cssl.service.IDeptService;
import com.cssl.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class ControllerKz {


    @Autowired
    IEmpService iEmpService;
    @Autowired
    IDeptService iDeptService;

    @RequestMapping("/index")
    public String SelectDept(Model m){
        m.addAttribute("m2",iDeptService.list());
        return "insert";
    }

    @RequestMapping("/update")
    public String update(Model m,Emp e){
        iEmpService.updateById(e);
        return list(1,3,m);
    }

    @RequestMapping("/selectById")
    public String selectById(Integer empno,Model m){
     Emp e=iEmpService.getById(empno);
     e.setDept(iDeptService.getById(e.getDeptno()));
     m.addAttribute("emp",e);
     m.addAttribute("m2",iDeptService.list());
      return  "update";

    }
   /* @ResponseBody
    @RequestMapping("/selectList")
    public Page list(int pageIndex, int pageSize, Model m){

     //   Page<Map<String,Object>> page=new Page<>(pageIndex,pageSize);

        return iEmpService.selectEmp_Dept(new  Page<Emp>(1,3));
    }*/

    @RequestMapping("/selectList")
    public String list(int pageIndex, int pageSize, Model m){

        //   Page<Map<String,Object>> page=new Page<>(pageIndex,pageSize);
        Page<Emp> page=iEmpService.selectEmp_Dept(new  Page<Emp>(pageIndex,pageSize));
        m.addAttribute("page",page);
        return "select";
    }

    @RequestMapping("/insert")
    public String insert(Emp emp){
        iEmpService.save(emp);
        return "select";
    }

}
