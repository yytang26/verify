package com.tyy.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author:tyy
 * @date:2021/5/15
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel("人物类")
public class Person {

    @ApiModelProperty("年龄")
    Integer age;

    @ApiModelProperty("年纪")
    String name;
}
