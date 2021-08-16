package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.IEmpDao;
import com.cssl.entity.Emp;
import com.cssl.service.IEmpService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Controller
public class EmpService extends ServiceImpl<IEmpDao,Emp> implements IEmpService {

    @Autowired
    IEmpDao iEmpDao;

    @Override
    public Page<Emp> selectEmp_Dept(IPage<Emp> page) {
        return iEmpDao.selectEmp_Dept(page, new QueryWrapper<Map<String,Object>>()
                .orderByDesc("empno"));
    }
}
