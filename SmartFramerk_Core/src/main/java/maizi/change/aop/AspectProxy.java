package maizi.change.aop;


import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author yubo
 * @version V2.0
 * @Description: 切面代理
 * @date 2018/8/15 下午4:15
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public abstract class AspectProxy implements Proxy{

    private static final Logger logger = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable{
       Object result = null;
       Class<?> cls = proxyChain.getTargetClass();
       Method method = proxyChain.getTargetMethod();
       Object[] params = proxyChain.getMethodParams();
       begin();
       try {
          if (intercept(cls,method,params))
          {
             before(cls,method,params);
             result = proxyChain.doProxyChain();
             after(cls,method,params,result);
          }else{
             result = proxyChain.doProxyChain();
          }
       }catch (Exception e){
          logger.error("切面代理 错误");
          error(cls,method,params,e);
          throw e;
       }finally {
           end();
       }
       return result;
    }


    private void begin() {

    }

    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable
    {
        return true;
    }

    public void before(Class<?> cls, Method method,Object[] params) throws Throwable{


    }

    public void after(Class<?> cls, Method method,Object[] params,Object result) throws Throwable{


    }

    public void error(Class<?> cls, Method method,Object[] params,Throwable e){


    }

    public void end(){

    }







}
