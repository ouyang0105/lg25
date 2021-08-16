package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.IVoteDao;
import com.cssl.entity.Vote;
import com.cssl.service.IVoteService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.NESTED)
@Controller
public class VoteService extends ServiceImpl<IVoteDao, Vote> implements IVoteService {
}
