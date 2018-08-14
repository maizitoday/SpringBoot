package com.maizi.framark;
import java.util.ArrayList;
import java.util.List;
import maizi.change.ioc.Service;
import maizi.change.servlet.Data;
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
}
