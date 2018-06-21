package com.example.demo.annotation;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.Login;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/16 下午10:29
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Repository
public interface LoginAnnotationDao {

    @Select("SELECT * FROM login")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
    })
    List<Login> queryAll();


    @Insert("INSERT INTO mysql.login (name, sex) VALUES ('4', '4');")
    boolean insert();


}
