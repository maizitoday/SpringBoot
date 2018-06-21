package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/15 下午2:52
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Repository
public class LoginDao {
	@Autowired
	public JdbcTemplate jdbcTemplate;

	public List<Login> queryAll() {
		String sql = "select * from login";
		List rows = jdbcTemplate.queryForList(sql);
        List<Login> loginList = new ArrayList<Login>();
        if (rows != null)
        {
            for (int i = 0; i < rows.size(); i++) {
                Map userMap = (Map)rows.get(i);
                Login login = new Login();
                login.setName((String) userMap.get("name"));
                login.setSex((String) userMap.get("sex"));
                loginList.add(login);
            }
        }
		return loginList;
	}
}
