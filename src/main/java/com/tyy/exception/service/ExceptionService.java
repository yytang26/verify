package com.tyy.exception.service;

import org.springframework.stereotype.Service;

/**
 * @author:tyy
 * @date:2021/5/15
 */


public interface ExceptionService {

    void exception(String s);

    void testBaseException();

    void testUnknownException();
}
