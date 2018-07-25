package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/13 下午4:13
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleEntity {
    private Integer age;
    private String name;
    private String callNumber;
    private String address;
    private String emile;
}
