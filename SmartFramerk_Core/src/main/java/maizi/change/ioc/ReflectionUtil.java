package maizi.change.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.LoggerFactory;

/**
 * @author yubo
 * @version V2.0
 * @Description:  反射设置类的值
 * @date 2018/8/8 下午6:55
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class ReflectionUtil {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /***
     * 创建实例
     * @param cls
     * @return
     */
    public static Object newInstance(Class<?> cls)
    {
        Object  instance;
        try {
           instance = cls.newInstance();
        }catch (Exception e){
            LOGGER.error("实例化对象失败",e);
            throw new RuntimeException(e);
        }
        return instance;
    }


    /***
     * 调用方法
     * @param obj
     * @param method
     * @param args
     * @return
     */
    public static Object invokeMethod(Object obj, Method method,Object... args)
    {
      Object result;
      try {
          method.setAccessible(true);
          result = method.invoke(obj,args);
      }catch (Exception e){
          LOGGER.error("调用方法失败",e);
          throw new RuntimeException(e);
      }
      return result;
    }

    /***
     * 设置成员变量的值
     * @param obj
     * @param field
     * @param value
     */
    public static  void setField(Object obj, Field field,Object value)
    {
      try {
         field.setAccessible(true);
         field.set(obj,value);
      }catch (Exception e){
          LOGGER.error("设置成员变量错误",e);
          throw new RuntimeException(e);
      }
    }
}
