package maizi;

import java.lang.reflect.Proxy;

/**
 * @author yubo
 * @version V2.0
 * @Description:  这个类有很多方法
 * @date 2018/8/21 下午3:13
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class MySqlSession {

    private Excutor  excutor = new MyExcutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String sql, Object parameter)
    {
        return  excutor.query(sql,parameter);
    }


    public <T> T getMapper(Class<T> clas){

        return (T)Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas},new MyMapperProxy(this,myConfiguration));
    }




}
