package maizi.change.transaction;

import java.sql.Connection;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/17 下午4:30
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class DatabaseHelper {

    /**
     * 开启事务
     */
    public static void beginTransaction()
    {
        Connection conn = DBUtil.getConnection();
        if (conn != null)
        {
            try {
               conn.setAutoCommit(false);
            }catch (Exception e){
               e.printStackTrace();
            }finally {
                DBUtil.closeConnection();
            }
        }
    }

    /***
     *  提交事务
     */
    public static void  commitTransaction()
    {
       Connection  conn = DBUtil.getConnection();
       if (conn != null)
       {
           try {
              conn.commit();
              conn.close();
           }catch (Exception e){
              e.printStackTrace();
           }finally {
               DBUtil.closeConnection();
           }
       }
    }

    /***
     *  回滚事务
     */
    public static void  rollbackTransaction()
    {
        Connection conn = DBUtil.getConnection();
        if (conn != null)
        {
            try {
               conn.rollback();
               conn.close();
            }catch (Exception e){
               e.printStackTrace();
            }finally {
                DBUtil.closeConnection();
            }
        }
    }
}
