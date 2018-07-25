package com.example.demo.dao.slave;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Sys;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/19 下午4:04
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Repository
public interface SysDao {
    List<Sys> findSysAll();

    void updateAll();
}
