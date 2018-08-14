package maizi.change.ioc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yubo
 * @version V2.0
 * @Description: 类操作处理， 获取Controller，service集合
 * @date 2018/8/8 下午7:22
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public  final class ClassHelper {

    /***
     * 定义类集合（用于存放所加载的类）
     */
    private static Set<Class<?>> CLASS_SET = new HashSet<Class<?>>();

    static {
        System.out.println("  ClassHelper  执行  ");
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /***
     * 获取应用包名下的所有类
     * @return
     */
    public static Set<Class<?>> getClassSet()
    {
        return CLASS_SET;
    }

    /***
     * 获取应用包名下的所有service类
     * @return
     */
   public static Set<Class<?>> getServiceClassSet()
   {
       Set<Class<?>> classSet = new HashSet<Class<?>>();
       for (Class<?> cls : CLASS_SET)
       {
           if (cls.isAnnotationPresent(Service.class))
           {
               classSet.add(cls);
           }
       }
       return classSet;
   }


    /***
     * 获取应用包名下所有的Controller类
     * @return
     */
   public static Set<Class<?>> getControllerClassSet()
   {
       Set<Class<?>> classSet = new HashSet<Class<?>>();
       for (Class<?> cls : CLASS_SET)
       {
           classSet.add(cls);
       }
       return classSet;
   }

    /***
     * 获取应用包名下所有的Bean类（包括Service，Controller）
     * @return
     */
   public static Set<Class<?>> getBeanClassSet()
   {
       Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
       beanClassSet.addAll(getServiceClassSet());
       beanClassSet.addAll(getControllerClassSet());
       return beanClassSet;
   }




}
