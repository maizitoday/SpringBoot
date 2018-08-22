package maizi.change.aop;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author yubo
 * @version V2.0
 * @Description: 代理管理器,创建代理器，切面来调用这个方法。
 * @date 2018/8/15 下午4:06
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class ProxyManager {

   public static <T> Object createProxy(final Class<?> targetClass, final List<Proxy> proxyList)
   {
       return (T)Enhancer.create(targetClass, new MethodInterceptor() {
           @Override
           public Object intercept(Object targetObject, Method targetMethod, Object[] methodParams, MethodProxy methodProxy) throws Throwable {
               return new ProxyChain(targetClass,targetObject,targetMethod,methodProxy,methodParams,proxyList).doProxyChain();
           }
       });
   }

}
