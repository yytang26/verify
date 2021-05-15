package com.tyy.swagger.service;

import com.tyy.swagger.dto.Person;
import io.swagger.annotations.ApiOperation;

/**
 * @author:tyy
 * @date:2021/5/15
 */
public interface SwaggerService {

    @ApiOperation("测试swagger")
    void test(Person person);
}
