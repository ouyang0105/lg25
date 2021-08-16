package com.cssl.service.impl;

import com.cssl.dao.IDeptDao;
import com.cssl.entity.Dept;
import com.cssl.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DeptService implements IDeptService {
    @Autowired
    IDeptDao iDeptDao;


    @Override
    public List<Dept> selectDept() {
        return iDeptDao.selectDept();
    }
}
