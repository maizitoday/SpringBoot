package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/13 下午4:14
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleDTO {
    private String phoneNumber;
    private String address;
    private String emile;
    private User  user;
}
