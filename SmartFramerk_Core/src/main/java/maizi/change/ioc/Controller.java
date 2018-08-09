package maizi.change.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yubo
 * @version V2.0
 * @Description:  控制器 注解
 * @date 2018/8/8 下午7:16
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
