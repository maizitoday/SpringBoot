package maizi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import mapper.User;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/21 下午3:15
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public class MyExcutor  implements Excutor{

    private MyConfiguration  myConfiguration = new MyConfiguration();

    @Override
    public <T> T query(String sql, Object parameter) {
        try {
            Connection connection = myConfiguration.getConnection();
            ResultSet set = null;
            PreparedStatement pre = null;
            pre = connection.prepareStatement(sql);
            pre.setString(1,parameter.toString());
            set = pre.executeQuery();
            User u = new User();
            while (set.next())
            {
                u.setId(set.getString(1));
                u.setUserName(set.getString(2));
                u.setPassWord(set.getString(3));
            }
            return (T)u;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
