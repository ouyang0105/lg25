package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.IOptionsDao;
import com.cssl.entity.Options;
import com.cssl.service.IOptionsService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.NESTED)
@Controller()
public class OptionsService extends ServiceImpl<IOptionsDao, Options> implements IOptionsService {

}
