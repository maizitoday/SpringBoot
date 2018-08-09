package maizi.change.servlet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yubo
 * @version V2.0
 * @Description: 返回视图对象
 * @date 2018/8/8 下午9:12
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class View {

    /**
     * 视图路径
     */
    private String path;

    /**
     * 数据模型
     */
    private Map<String,Object> model;


    public View(String path){
        this.path = path;
        model = new HashMap<String,Object>();
    }

    public View addModle(String key,Object value)
    {
        model.put(key,value);
        return this;
    }

    public String getPath()
    {
        return path;
    }

    public Map<String,Object> getModel()
    {
        return model;
    }
}
