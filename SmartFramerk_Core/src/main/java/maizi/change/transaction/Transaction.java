package maizi.change.transaction;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/17 下午4:29
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction {


}
