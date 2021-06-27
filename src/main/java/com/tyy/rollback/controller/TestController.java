package com.tyy.rollback.controller;

import com.tyy.rollback.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:tyy
 * @date:2021/6/27
 */

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public void test(){
        testService.test();
    }
}
