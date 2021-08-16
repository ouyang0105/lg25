package com.cssl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISubjectService extends IService<Subject>{

    boolean insert_subject_option(Subject su);

    Page<Map<String,Object>> votelist(IPage<Map<String,Object>> page,@Param("ew") QueryWrapper<Map<String,Object>> qw);

    boolean delete(Integer sid);

     void update(Subject subject,int[] oid,String[] options,String[] options1,int[] del);
}
