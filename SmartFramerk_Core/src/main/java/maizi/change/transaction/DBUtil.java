package maizi.change.transaction;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/17 下午4:32
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class DBUtil {
    private static  String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/sys?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String username = "root";
    private static String password = "123456";
    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = connContainer.get();
        try {
           if (conn == null)
           {
               Class.forName(driver);
               conn = DriverManager.getConnection(url,username,password);
               conn.setAutoCommit(false);
           }
        }catch (Exception e){
           e.printStackTrace();
        }finally {
            connContainer.set(conn);
        }
        return conn;
    }

    /***
     *  关闭链接
     */
    public static void closeConnection()
    {
       Connection conn = connContainer.get();
       try {
           if (conn != null)
           {
               conn.close();
           }
       }catch (Exception e){
          e.printStackTrace();
       }finally {
           connContainer.remove();
       }
    }

}
