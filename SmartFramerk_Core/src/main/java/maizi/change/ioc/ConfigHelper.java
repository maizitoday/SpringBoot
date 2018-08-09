package maizi.change.ioc;

import java.util.Properties;

/**
 * @author yubo
 * @version V2.0
 * @Description:  属性文件助手类
 * @date 2018/8/8 下午3:15
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public  final class ConfigHelper {

    private static final Properties properties = new PropsUtil(ConfigConstant.CONFIG_FILE).getProperties();

    /***
     * 获取JDBC驱动
     * @return
     */
    public  static  String  getJdbcDriver()
    {
        return properties.getProperty(ConfigConstant.JDBC_DRIVER);
    }

    /***
     * 获取JDBC URL
     * @return
     */
    public static String getJdbcUrl()
    {
        return properties.getProperty(ConfigConstant.JDBC_URL);
    }

    /***
     * 获取JDBC 用户名
     * @return
     */
    public static String getJdbcUserName()
    {
        return properties.getProperty(ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取JDBC密码
     * @return
     */
    public static String getJdbcPassWord()
    {
        return  properties.getProperty(ConfigConstant.JDBC_PASSWORD);
    }


    /**
     * 获取应用基础包名
     * @return
     */
    public static String getAppBasePackage()
    {
        return properties.getProperty(ConfigConstant.APP_BASE_PACKAGE);
    }

    /***
     * 获取JSP路径
     * @return
     */
    public static String getAppJspPath()
    {
        return properties.getProperty(ConfigConstant.APP_JSP_PATH,"/WEB-INF/view/");
    }

    /***
     * 获取应用静态资源路径
     * @return
     */
    public static String getAppAssetPath()
    {
        return properties.getProperty(ConfigConstant.APP_ASSET_PATH,"/asset/");
    }


}
