package com.example.demo.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/24 上午11:26
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@ApiModel(description = "用户请求表单")
@Data
public class User {
    @ApiModelProperty(value = "用户id")
    private int id;
    @ApiModelProperty(value = "用户名字")
    private String username;
    @ApiModelProperty(value = "用户年龄")
    private int age;

}
