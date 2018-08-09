package maizi.change.ioc;

import java.lang.reflect.Method;

/**
 * @author yubo
 * @version V2.0
 * @Description:  封装Action信息
 * @date 2018/8/8 下午8:34
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class Handler {

    /**
     * controller 类
     */
    private Class<?> controllerClass;

    /**
     * Action 方法
     */
    private Method actionMethod;


    public Handler(Class<?> controllerClass,Method actionMethod)
    {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }


    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public void setControllerClass(Class<?> controllerClass) {
        this.controllerClass = controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    public void setActionMethod(Method actionMethod) {
        this.actionMethod = actionMethod;
    }
}
