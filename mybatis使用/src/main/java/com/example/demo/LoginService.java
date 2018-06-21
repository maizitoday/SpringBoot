package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.annotation.LoginAnnotationDao;
import com.example.demo.dao.LoginDao;
import com.example.demo.pojo.Login;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/16 下午9:39
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
public class LoginService {

   @Autowired
   private LoginDao loginDao;

    @Autowired
    private LoginAnnotationDao loginAnnotationDao;

   public List<Login> findAll(){
       return loginDao.findAll();
   }

    public List<Login> findAnnotationAll(){
        return loginAnnotationDao.queryAll();
    }

    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
    public boolean  insert() throws Exception {
       boolean  flag =  loginAnnotationDao.insert();
       throw new Exception("插入失败");
    }
}
