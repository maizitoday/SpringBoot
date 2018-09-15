package com.example.demo.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/9/15 下午3:10
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Repository
public abstract class BaseDaoImpl<T> extends SqlSessionDaoSupport implements IBaseDao<T>
{

    @Resource
    @Override
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public int deleteByPrimaryKey(String id)
    {
        return getSqlSession().delete(getClass().getName() + "." + "deleteByPrimaryKey", id);
    }

    @Override
    public int insert(T o)
    {
        return getSqlSession().insert(getClass().getName() + "." + "insert", o);
    }

    @Override
    public int insertSelective(T o)
    {
        return getSqlSession().insert(getClass().getName() + "." + "insertSelective", o);
    }

    @Override
    public T selectByPrimaryKey(Integer id)
    {
        return getSqlSession().selectOne(getClass().getName() + "." + "selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(T o)
    {
        return getSqlSession().update(getClass().getName() + "." + "updateByPrimaryKeySelective",
                o);
    }

    @Override
    public int updateByPrimaryKey(T o)
    {
        return getSqlSession().update(getClass().getName() + "." + "updateByPrimaryKey", o);
    }

}

