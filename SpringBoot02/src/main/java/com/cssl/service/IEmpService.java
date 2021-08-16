package com.cssl.service;

import com.cssl.entity.Emp;
import com.github.pagehelper.Page;

import java.util.List;

public interface IEmpService {
    int insertEmp(Emp e);
    Page<Emp> selectEmp(Integer pageno, Integer pagesize);
    Emp selectOne(Integer empno);
    int update(Emp emp);
}
