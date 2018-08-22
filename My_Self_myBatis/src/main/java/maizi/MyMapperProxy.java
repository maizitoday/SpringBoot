package maizi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

import mapper.Function;
import mapper.MapperBean;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/21 下午3:28
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class MyMapperProxy implements InvocationHandler{


    private MySqlSession  mySqlSession;
    private MyConfiguration myConfiguration;

    public MyMapperProxy(MySqlSession mySqlSession, MyConfiguration myConfiguration) {
        this.mySqlSession = mySqlSession;
        this.myConfiguration = myConfiguration;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean mapperBean = myConfiguration.readMapper();
        if (!method.getDeclaringClass().getName().equals(mapperBean.getInterfaceName()))
        {
            return null;
        }
        List<Function> list = mapperBean.getList();
        if (list != null && list.size() > 0)
        {
            for (Function function : list)
            {
                if (method.getName().equals(function.getFuncName()))
                {
                    return mySqlSession.selectOne(function.getSql(),String.valueOf(args[0]));
                }
            }
        }
        return null;
    }
}
