package com.cssl.dao;

import com.cssl.entity.Emp;

import java.util.List;

public interface IEmpDao {
    int insertEmp(Emp e);
    List<Emp> selectEmp();
    Emp selectOne(Integer empno);
    int update(Emp emp);
}
