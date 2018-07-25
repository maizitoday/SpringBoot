package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/24 上午11:26
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */


/***
 *  swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
    @Api：修饰整个类，描述Controller的作用
    @ApiOperation：描述一个类的一个方法，或者说一个接口
    @ApiParam：单个参数描述
    @ApiModel：用对象来接收参数
    @ApiProperty：用对象接收参数时，描述对象的一个字段
    @ApiResponse：HTTP响应其中1个描述
    @ApiResponses：HTTP响应整体描述
    @ApiIgnore：使用该注解忽略这个API
    @ApiError ：发生错误返回的信息
    @ApiImplicitParam：一个请求参数
    @ApiImplicitParams：多个请求参数
 */
@Api(value = "这个controller的作用")
@RestController
public class UserController {

    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "添加User对象", required = true, dataType = "User")
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String add (@RequestBody User user){
           users.put(1,user);
           return "success";
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "delUser/{id}", method = RequestMethod.POST)
    public String delete (@PathVariable(value = "id") Integer id){
        User user = users.remove(id);
        if (user != null)
        {
            return "删除成功";
        }
        return "删除失败";
    }

    /**
     * 查询用户列表
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "users", method = RequestMethod.POST)
    public List<User> getUserList () {
        List<User> userList = new ArrayList<>();
        for(int i = 0 ; i<5;i++)
        {
            User user = new User();
            user.setId(i);
            user.setAge(i*2);
            user.setUsername("小强"+i);
            userList.add(user);
        }
        return userList;
    }


    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.POST)
    public Map<Integer, User> update (@PathVariable("id") Integer id, @RequestBody User user){
           User currentUser = users.get(id);
           currentUser.setUsername("小花");
           users.put(id,currentUser);
           return users;
    }

}
