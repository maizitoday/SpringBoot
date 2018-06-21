/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/15 上午10:26
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public interface MyInterfaceOne {

    static void showMethodName(){

        System.out.println("   MyInterfaceOne  ");
    }

    default void  setMsg(){

        System.out.println(" MyInterfaceOne----接口中定义方法体 ");
    }

}
