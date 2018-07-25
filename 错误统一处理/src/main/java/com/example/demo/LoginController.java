package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/22 上午10:02
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Controller
public class LoginController {

    @RequestMapping("loginView")
    public ModelAndView  loginView() throws MyPageException {
        throw  new MyPageException("page页面错误异常",404);
    }

    @RequestMapping("loginJson")
    @ResponseBody
    public String  loginJson() throws MyJsonException {
        throw  new MyJsonException("json错误异常",504);
    }

}
