package com.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.ISubjectDao;
import com.cssl.entity.Options;
import com.cssl.entity.Subject;
import com.cssl.entity.Vote;
import com.cssl.service.IOptionsService;
import com.cssl.service.ISubjectService;
import com.cssl.service.IVoteService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Transactional(rollbackFor = Exception.class)
@Controller
public class SubjectService extends ServiceImpl<ISubjectDao, Subject> implements ISubjectService {

    @Autowired
    IOptionsService iOptionsService;

    @Autowired
    ISubjectDao iSubjectDao;

    @Autowired
    IVoteService iVoteService;


    public boolean insert_subject_option(Subject su){
        boolean pd=true;
        pd=save(su);
        Subject subject=getOne(new QueryWrapper<Subject>().eq("title",su.getTitle()));

        for (String opent:su.getOptions()){
            pd=iOptionsService.save(new Options(null,opent,subject.getSid()));
            if(pd==false){
                break;
            }
        }

        return pd;
    }

    @Override
    public Page<Map<String,Object>> votelist(IPage<Map<String,Object>> page,@Param("ew") QueryWrapper<Map<String,Object>> qw) {
        return iSubjectDao.votelist(page,qw);
    }

    @Override
    public boolean delete(Integer sid) {
        boolean pd=false;
        pd=iVoteService.remove(new QueryWrapper<Vote>().eq("sid",sid));
        pd=iOptionsService.remove(new QueryWrapper<Options>().eq("op_sid",sid));
        pd=remove(new QueryWrapper<Subject>().eq("sid",sid));
        if(!pd){
            int num=2/0;
        }
        return pd;
    }

    public void update(Subject subject,int[] oid,String[] options,String[] options1,int[] del){
        System.out.println(subject);
        //修改主题
        updateById(subject);
        //修改选项
        for(int i=0;i<oid.length;i++){
            iOptionsService.updateById(new Options(oid[i],options[i], subject.getSid()));
        }
        //新增选项
      if (options1!=null){
          List<Options> list=new ArrayList<>();
          for (int i=0;i<options1.length;i++){
              list.add(new Options(0,options1[i], subject.getSid()));
          }
          iOptionsService.saveBatch(list);
      }


       if (del!=null){
           //删除选项
           for (int n:del){
               iVoteService.removeById(n);
               iOptionsService.removeById(n);
           }

         //  iVoteService.remove(new QueryWrapper<Vote>().in("oid",Arrays.asList()));
       }



    }




}
