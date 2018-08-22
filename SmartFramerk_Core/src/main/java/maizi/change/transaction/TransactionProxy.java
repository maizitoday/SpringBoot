package maizi.change.transaction;

import java.lang.reflect.Method;

import maizi.change.aop.Proxy;
import maizi.change.aop.ProxyChain;

/**
 * @author yubo
 * @version V2.0
 * @Description:  事务代理切面类
 * @date 2018/8/17 下午4:50
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class TransactionProxy implements Proxy{

    private static ThreadLocal<Boolean> FLAG_HOLDR = new ThreadLocal<Boolean>(){

        @Override
        protected Boolean initialValue() {
             return false;
        }
    };


    @Override
    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object  result;
        boolean flag = FLAG_HOLDR.get();
        Method method = proxyChain.getTargetMethod();
        if (!flag && method.isAnnotationPresent(Transaction.class))
        {
            FLAG_HOLDR.set(true);
            try {
               DatabaseHelper.beginTransaction();
               System.out.println("  事物开启成功   ");
               result = proxyChain.doProxyChain();
               DatabaseHelper.commitTransaction();
               System.out.println("  事物提交成功   ");
            }catch (Exception e){
                DatabaseHelper.rollbackTransaction();
                System.out.println("  事物回滚成功   ");
                throw e;
            }finally {
                FLAG_HOLDR.remove();
            }
        }else{
            result = proxyChain.doProxyChain();
        }
        return result;
    }
}
