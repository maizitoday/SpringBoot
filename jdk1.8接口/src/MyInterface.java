/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/15 上午10:22
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public interface MyInterface {

    static void showMethodName(){

        System.out.println("   showMethodName  ");
    }

    default void  setMsg(){

        System.out.println(" MyInterface----接口中定义方法体 ");
    }


}
