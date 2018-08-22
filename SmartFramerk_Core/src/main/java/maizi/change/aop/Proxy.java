package maizi.change.aop;

/**
 * @author yubo
 * @version V2.0
 * @Description:  执行链式代理
 * @date 2018/8/15 下午3:54
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;

}
