package com.maizi.framark;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import maizi.change.ioc.Service;
import maizi.change.servlet.Data;
import maizi.change.transaction.DBUtil;
import maizi.change.transaction.Transaction;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/8/10 下午5:50
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Service
public class UserService {
    /**
     * 登录
     * @param userName
     * @param passWord
     * @return
     */
	public Data login(String userName, String passWord) {
		List<String> list = new ArrayList<String>();
		list.add(userName);
		list.add(passWord);
		Data data = new Data();
		data.setModel(list);
		return data;
	}

    @Transaction
	public void  addSlave(){
		Connection conn = DBUtil.getConnection();
		try {
			Statement statement = conn.createStatement();
			if (statement != null)
			{
				String  sql = "INSERT INTO slave (id, name, age) VALUES (3, '3', 3)";
				int count =  statement.executeUpdate(sql);
				if (count > 0)
				{
					System.out.println("   插入成功  ");
				}else {
					System.out.println("   插入失败  ");
				}
			}
//			int index = 1/0;
		} catch (SQLException e) {
			System.out.println("  自定义注解异常   ");
			e.printStackTrace();
		}  // 感觉只有在横切的感念中，我们才需要把异常往外面扔。也就是在异常里面处理业务逻辑。
//		catch (ArithmeticException e)
//		{
//			System.out.println("  为0了，    ");
//			e.printStackTrace();
//		}


	}




}
