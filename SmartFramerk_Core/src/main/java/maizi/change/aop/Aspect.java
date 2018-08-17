package maizi.change.aop;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/15 下午3:52
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {

    Class<? extends Annotation> value();
}
