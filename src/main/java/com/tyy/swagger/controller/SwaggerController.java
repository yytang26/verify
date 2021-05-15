package com.tyy.swagger.controller;

import com.tyy.exception.entity.BaseResponse;
import com.tyy.swagger.dto.Person;
import com.tyy.swagger.service.SwaggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author:tyy
 * @date:2021/5/15
 */

@RestController
public class SwaggerController {

    @Autowired
    private SwaggerService swaggerService;

    @PostMapping("/testSwagger")
    public BaseResponse testSwagger(@RequestBody  Person person){
        swaggerService.test(person);
        return BaseResponse.success("成功");
    }
}
