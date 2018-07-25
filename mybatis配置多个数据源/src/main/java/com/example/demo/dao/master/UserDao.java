package com.example.demo.dao.master;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.pojo.User;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/19 下午4:03
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Repository
public interface UserDao {

   List<User> findUserAll();

   void updateAll();

}
