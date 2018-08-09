package maizi.change.ioc;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author yubo
 * @version V2.0
 * @Description:  封装请求信息
 * @date 2018/8/8 下午8:29
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class Request {
    /***
     * 请求方法
     */
    private String requestMethod;

    /**
     * 请求路径
     */
    private String requestPath;

    public  Request(String requestMethod,String requestPath)
    {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }


    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this,o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
