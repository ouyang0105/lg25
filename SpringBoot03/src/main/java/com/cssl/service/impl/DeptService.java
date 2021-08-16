package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.IDeptDao;
import com.cssl.dao.IEmpDao;
import com.cssl.entity.Dept;
import com.cssl.entity.Emp;
import com.cssl.service.IDeptService;
import com.cssl.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class DeptService  extends ServiceImpl<IDeptDao, Dept> implements IDeptService {




}
