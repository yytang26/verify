package com.tyy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.tyy.aop.mapper")
public class VerifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(VerifyApplication.class, args);
    }

}
