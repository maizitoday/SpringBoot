package maizi.change.servlet;

import java.util.Map;

/**
 * @author yubo
 * @version V2.0
 * @Description: 请求参数对象
 * @date 2018/8/8 下午9:08
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class Param {

    private Map<String,Object> paramMap;


    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }


    public Map<String,Object> getParamMap()
    {
        return paramMap;
    }


}
