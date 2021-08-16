package com.cssl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.entity.Emp;

import java.util.List;
import java.util.Map;

public interface IEmpService extends IService<Emp> {

    Page<Emp> selectEmp_Dept(IPage<Emp> page);
}
