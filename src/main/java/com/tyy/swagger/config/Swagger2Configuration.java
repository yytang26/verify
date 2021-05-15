package com.tyy.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:tyy
 * @date:2021/5/15
 */

@Configuration
@EnableSwagger2
@Profile({"dev","test"})
public class Swagger2Configuration {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tyy"))
                .build()
                .globalOperationParameters(addHeaders());

    }

    private List<Parameter> addHeaders() {

        List<Parameter> pars = new ArrayList<>();
        ParameterBuilder ticketPar = new ParameterBuilder();

        ticketPar.name("x-auth").description("user_token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(ticketPar.build());

        ParameterBuilder ticketParChannel = new ParameterBuilder();
        ticketParChannel.name("channel").description("user channel")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        pars.add(ticketParChannel.build());
        return pars;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger文档")
                .description("自测文档")
                .version("1.0")
                .build();
    }

}
