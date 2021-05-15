package com.tyy.exception.controller;

import com.tyy.exception.entity.BaseResponse;
import com.tyy.exception.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:tyy
 * @date:2021/5/15
 */

@RestController
public class ExceptionController {

    @Autowired
    private ExceptionService exceptionService;

    @RequestMapping("/exception")
    public BaseResponse exception(@RequestBody String s){
        exceptionService.exception(s);
        return BaseResponse.success(s);

    }

    @RequestMapping("/testBaseException")
    public BaseResponse testBaseException(){
        exceptionService.testBaseException();
        return BaseResponse.success();

    }

    @RequestMapping("/testUnknownException")
    public BaseResponse testUnknownException(){
        exceptionService.testUnknownException();
        return BaseResponse.success();

    }
}
