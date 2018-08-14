package com.maizi.framark.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/14 下午2:47
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class TestMain {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

		Class stuClass = Class.forName("com.maizi.framark.Test.User");
		Object obj = stuClass.getConstructor().newInstance();
        Method[] methodArray = stuClass.getDeclaredMethods();
        Method m = methodArray[0];
        m.setAccessible(true);// 解除私有限定
        Object result = m.invoke(obj, "20","10");// 需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);

	}
}
