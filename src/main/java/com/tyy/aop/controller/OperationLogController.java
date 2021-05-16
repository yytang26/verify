package com.tyy.aop.controller;

import com.tyy.aop.aop.OperationLog;
import com.tyy.exception.entity.BaseResponse;
import com.tyy.exception.exception.BusinessException;
import com.tyy.swagger.dto.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:tyy
 * @date:2021/5/16
 */

@RestController
public class OperationLogController {

    @RequestMapping("/testOperationLog")
    @OperationLog(action = "测试注解",remark = "测试")
    public BaseResponse testOperationLog(@RequestBody Person person){
        throw new BusinessException("抛出异常");
       // return BaseResponse.success();
    }
}
