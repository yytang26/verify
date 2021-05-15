package com.tyy.exception.service.impl;

import com.tyy.exception.exception.BaseException;
import com.tyy.exception.exception.BusinessException;
import com.tyy.exception.exception.UnKnownException;
import com.tyy.exception.service.ExceptionService;
import org.springframework.stereotype.Service;

/**
 * @author:tyy
 * @date:2021/5/15
 */

@Service
public class ExceptionServiceImpl implements ExceptionService {

    @Override
    public void exception(String s) {
        throw new BusinessException("抛出一个bussiness exception");
    }

    public void testBaseException(){
        throw new BaseException("抛出一个BaseException");
    }

    @Override
    public void testUnknownException() {
        throw new UnKnownException("抛出 unknownException");
    }
}
