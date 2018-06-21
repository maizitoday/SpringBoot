package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Login;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/16 下午9:39
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Repository
public interface LoginDao {
    List<Login> findAll();
}