package com.cssl.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.entity.Subject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISubjectDao extends BaseMapper<Subject> {

    Page votelist(IPage<Map<String,Object>> page,@Param("ew") QueryWrapper<Map<String,Object>> qw);
}
