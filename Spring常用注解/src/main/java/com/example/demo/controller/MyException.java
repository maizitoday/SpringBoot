package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/4 下午6:22
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends  RuntimeException{
    private String code;
    private String msg;
}
