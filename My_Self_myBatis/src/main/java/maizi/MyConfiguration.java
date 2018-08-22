package maizi;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mapper.Function;
import mapper.MapperBean;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/21 下午1:46
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class MyConfiguration {

    private static  String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://127.0.0.1:3306/sys?useUnicode=true&characterEncoding=utf-8&useSSL=false";
    private static String username = "root";
    private static String password = "123456";
    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection() throws Exception{
        Connection conn = connContainer.get();
        Class.forName(driver);
        conn = DriverManager.getConnection(url,username,password);
        conn.setAutoCommit(false);
        return conn;
    }

    /***
     *  关闭链接
     */
    public void closeConnection() throws Exception
    {
        Connection conn = connContainer.get();
        if (conn != null)
        {
            conn.close();
        }
        connContainer.remove();
    }

    /***
     * 读取写入SQL的配置文件，获取他的SQL语句，返回值，传入的参数
     * @param path
     * @return
     */
    public MapperBean readMapper()
    {
        ClassLoader  loader = ClassLoader.getSystemClassLoader();
        MapperBean  mapperBean = new MapperBean();
        try {
            InputStream stream =  MyConfiguration.class.getResourceAsStream("/maizi/UserMapper.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(stream);
            Element root = document.getRootElement();
            // 把nameSpace值为接口名
            mapperBean.setInterfaceName(root.attributeValue("nameSpace").trim());
            // 存储方法
            List<Function> list = new ArrayList<Function>();
            // 遍历根节点下面所有节点
            for(Iterator rootIter = root.elementIterator();rootIter.hasNext();)
            {
              Function fun = new Function();
              Element e = (Element) rootIter.next();
              String sqltype = e.getName().trim();
              String funcName = e.attributeValue("id").trim();
              String sql = e.getText().trim();
              String  resultType = e.attributeValue("resultType").trim();
              // sql 类型是 查询还是修改等
              fun.setSqlType(sqltype);
              fun.setFuncName(funcName);
              Object newInstance = null;
              newInstance = Class.forName(resultType).newInstance();
              fun.setResultType(newInstance);
              fun.setSql(sql);
              System.out.println("   fun:  "+fun.toString());
              list.add(fun);
            }
            mapperBean.setList(list);
        }catch (Exception e){
           e.printStackTrace();
        }
        return mapperBean;
    }







}
