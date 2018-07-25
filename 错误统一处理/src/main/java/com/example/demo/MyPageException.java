package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/22 上午9:57
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPageException extends Exception{
    private String exceptionMsg;
    private int code;
}
