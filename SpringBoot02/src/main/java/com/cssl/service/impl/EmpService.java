package com.cssl.service.impl;

import com.cssl.dao.IEmpDao;
import com.cssl.entity.Emp;
import com.cssl.service.IEmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmpService implements IEmpService {

    @Autowired
    IEmpDao iEmpDao;
    @Override
    public int insertEmp(Emp e) {
        return iEmpDao.insertEmp(e);
    }

    public Page<Emp> selectEmp(Integer pageno,Integer pagesize){
        Page<Emp> page= PageHelper.startPage(pageno,pagesize);
        iEmpDao.selectEmp();
       // page.getResult().forEach(System.out::println);
        return page;
    }

    @Override
    public Emp selectOne(Integer empno) {
        return iEmpDao.selectOne(empno);
    }

    @Override
    public int update(Emp emp) {
        return iEmpDao.update(emp);
    }
}
