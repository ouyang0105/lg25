package com.cssl.controller;

import com.cssl.entity.Emp;
import com.cssl.service.IDeptService;
import com.cssl.service.IEmpService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerKz {

    @Autowired
    IDeptService iDeptService;
    @Autowired
    IEmpService iEmpService;

    @RequestMapping("/du")
    public String du(Model m){
    m.addAttribute("m2",iDeptService.selectDept());
    return "insert";
    }

    @RequestMapping("/insert")
    public String insert(Emp e,Model m){
        System.out.println(e);
        boolean b=iEmpService.insertEmp(e)>0?true:false;
       if(b){

           return  selectEmp(m,1,3);
       }else{
           return du(m);
       }
    }

    @RequestMapping("/selectEmp")
    public String selectEmp(Model m,Integer pageno,Integer pagesize){
        if(pageno==null){
            pageno=1;
        }
        if (pagesize==null){
            pagesize=4;
        }
     //   Page<Emp> page=;
      //  page.forEach(System.out::println);
        m.addAttribute("list",iEmpService.selectEmp(pageno,pagesize));
        System.out.println("select");

        return "select";
    }


    @RequestMapping("/selectOne")
    public String selectOne( Integer empno,Model m){
        m.addAttribute("emp",iEmpService.selectOne(empno));
        m.addAttribute("m2",iDeptService.selectDept());

        return "update.html";
    }

    @RequestMapping("/update")
    public String update(Emp emp,Model m){
        System.out.println(emp);
        iEmpService.update(emp);
        return  selectEmp(m,1,3);
    }

}
