package maizi.change.ioc;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/8 下午8:06
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public final class IocHelper {

    static {
        // 获取所有的Bean类与Bean实例之间的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
       if (beanMap != null)
       {
           for (Map.Entry<Class<?>,Object> beanEntry : beanMap.entrySet())
           {
               Class<?> beanClass = beanEntry.getKey();
               Object beanInstance = beanEntry.getValue();
               Field[] beanFields = beanClass.getDeclaredFields();
               // 获取类的所有属性
               if (beanFields != null)
               {
                   // 获取Inject注解的类，实例化这个对象
                   for (Field beanField : beanFields)
                   {
                     if (beanField.isAnnotationPresent(Inject.class))
                     {
                        Class<?> beanFieldClass = beanField.getType();
                        Object beanFieldInstance = beanMap.get(beanFieldClass);
                        if (beanFieldInstance != null)
                        {
                            ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                        }
                     }
                   }
               }

           }

       }


    }

}
