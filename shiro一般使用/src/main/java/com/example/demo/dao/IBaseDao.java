package com.example.demo.dao;
/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/9/15 下午2:44
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
public interface IBaseDao<T> {
	int deleteByPrimaryKey(String id);

	int insert(T o);

	int insertSelective(T o);

	T selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(T o);

	int updateByPrimaryKey(T o);
}
