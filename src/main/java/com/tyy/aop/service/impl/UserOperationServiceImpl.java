package com.tyy.aop.service.impl;

import com.tyy.aop.mapper.UserOperationMapper;
import com.tyy.aop.pojo.UserOperation;
import com.tyy.aop.req.UserOperationReq;
import com.tyy.aop.service.UserOperationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:tyy
 * @date:2021/5/16
 */
@Service
public class UserOperationServiceImpl implements UserOperationService {

    @Autowired
    UserOperationMapper userOperationMapper;

    @Override
    public void save(UserOperationReq userOperationReq) {
        UserOperation userOperation = new UserOperation();
        BeanUtils.copyProperties(userOperationReq,userOperation);
//        userOperation.setCreateTime(new Date());
//        userOperation.setUpdateTime(new Date());
//        userOperation.setIsDelete(0);
        userOperationMapper.insertSelective(userOperation);
    }
}
