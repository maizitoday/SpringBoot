package com.maizi.framark;

import maizi.change.ioc.Action;
import maizi.change.ioc.Controller;
import maizi.change.ioc.Inject;
import maizi.change.servlet.Data;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/10 下午5:50
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Controller
public class UserController {

    @Inject
    private UserService userService;

    @Action("get:/login")
    public Data login(String userName, String passWord){
        return userService.login(userName,passWord);
    }

    @Action("get:/test")
    public Data test(){
        return userService.login("1","2");
    }
}
