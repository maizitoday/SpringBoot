package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/7/9 下午10:00
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Controller
public class StaticController {

    @RequestMapping("showView")
    public String showView(){

        return "login/index";
    }

}
