package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/22 上午9:56
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */

/***
 *  系统异常统一处理，在这里直接可以记录到日志文件中， 统一处理。
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "errorPrompt";
    /***
     * 页面错误
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyPageException.class)
    public ModelAndView businessExceptionHandler(HttpServletRequest req, MyPageException e){
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg", e.getExceptionMsg());
        mav.addObject("code", 410);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    /***
     * JSON 格式错误
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyJsonException.class)
    @ResponseBody
    public Map<String, Object> jsonExceptionHandler(HttpServletRequest req, MyJsonException e) {
        Map<String, Object> re = new HashMap<String, Object>();
        re.put("code",e.getCount());
        re.put("msg", e.getExceptionMsg());
        return re;
    }
}
