package maizi.change.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.MethodProxy;


/**
 * @author yubo
 * @version V2.0
 * @Description:  代理链
 * @date 2018/8/15 下午3:55
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class ProxyChain {

    private Class<?> targetClass;
    private Object targtObject;
    private Method targetMethod;
    private MethodProxy methodProxy;
    private Object[] methodParams;

    private List<Proxy> proxyList = new ArrayList<Proxy>();
    private int proxyIndex = 0;

    public ProxyChain(Class<?> targetClass, Object targtObject, Method targetMethod, MethodProxy methodProxy, Object[] methodParams, List<Proxy> proxyList) {
        this.targetClass = targetClass;
        this.targtObject = targtObject;
        this.targetMethod = targetMethod;
        this.methodProxy = methodProxy;
        this.methodParams = methodParams;
        this.proxyList = proxyList;
    }

    public Object  doProxyChain() throws Throwable
    {
        Object methodResult;
        if (proxyIndex < proxyList.size())
        {   // 如果有多个代理， 这边先把代理链条全部执行
            methodResult = proxyList.get(proxyIndex++).doProxy(this);
        }else{
            // 最后执行具体的业务代码
            methodResult = methodProxy.invokeSuper(targtObject,methodParams);
        }
        return methodResult;
    }


    public Class<?> getTargetClass() {
        return targetClass;
    }

    public void setTargetClass(Class<?> targetClass) {
        this.targetClass = targetClass;
    }

    public Object getTargtObject() {
        return targtObject;
    }

    public void setTargtObject(Object targtObject) {
        this.targtObject = targtObject;
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public void setTargetMethod(Method targetMethod) {
        this.targetMethod = targetMethod;
    }

    public MethodProxy getMethodProxy() {
        return methodProxy;
    }

    public void setMethodProxy(MethodProxy methodProxy) {
        this.methodProxy = methodProxy;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(Object[] methodParams) {
        this.methodParams = methodParams;
    }

    public List<Proxy> getProxyList() {
        return proxyList;
    }

    public void setProxyList(List<Proxy> proxyList) {
        this.proxyList = proxyList;
    }

    public int getProxyIndex() {
        return proxyIndex;
    }

    public void setProxyIndex(int proxyIndex) {
        this.proxyIndex = proxyIndex;
    }
}