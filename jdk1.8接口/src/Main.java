/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/14 下午8:48
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class Main implements MyInterface,MyInterfaceOne{

    public static void main(String[] args){
        Main test = new Main();
        test.setMsg();
        MyInterface.showMethodName();
        MyInterfaceOne.showMethodName();
    }


    @Override
    public void setMsg() {
       System.out.println(" 两个接口都有这个方法， 这个时候需要重写这个方法，覆盖    ");
    }

}
