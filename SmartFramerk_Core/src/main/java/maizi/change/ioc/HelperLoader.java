package maizi.change.ioc;

/**
 * @author yubo
 * @version V2.0
 * @Description: 加载相应的Helper类
 * @date 2018/8/8 下午9:01
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class HelperLoader {

    public static void init()
    {
        Class<?>[] classList = {ClassHelper.class,BeanHelper.class,IocHelper.class,ControllerHelper.class};
        for (Class<?> cls : classList)
        {
            ClassUtil.loadClass(cls.getName(),true);
        }

    }


}
