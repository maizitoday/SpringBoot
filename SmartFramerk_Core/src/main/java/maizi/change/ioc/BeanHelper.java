package maizi.change.ioc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yubo
 * @version V2.0
 * @Description:  获取所有的bean， 设置class->bean
 * @date 2018/8/8 下午7:08
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public final class BeanHelper {

    /**
     * 定义Bean,用于存放Bean类和Bean实例的映射关系
     */
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        System.out.println("  BeanHelper  执行  ");
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet)
        {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }
    }

    /**
     * 获取Bean映射
     * @return
     */
    public static Map<Class<?>,Object> getBeanMap()
    {
        return BEAN_MAP;
    }


    /**
     * 获取Bean实例
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> cls)
    {
        if (!BEAN_MAP.containsKey(cls))
        {
            throw new RuntimeException("没有这个class类");
        }
        return (T)BEAN_MAP.get(cls);
    }


}
