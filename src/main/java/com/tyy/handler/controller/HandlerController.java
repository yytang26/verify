package com.tyy.handler.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:tyy
 * @date:2021/5/10
 */

@RestController
@RequestMapping("/")
public class HandlerController {


    @GetMapping("/demo")
    public String handlerDemo(){
        return "Hello World";
    }

}
