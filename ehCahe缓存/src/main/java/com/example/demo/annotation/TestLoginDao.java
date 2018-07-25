package com.example.demo.annotation;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.TestLogin;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/10 下午9:12
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Repository
public interface TestLoginDao {

    @Select("SELECT * FROM testLogin where id = #{id} ")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
    })
    TestLogin queryById(int id);


    @Update("update testLogin set sex = '1111' where id = #{id} ")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
    })
    int  updateById(int id);


    @Delete("delete from testLogin where id = #{id} ")
    int  delById(int id);


}
