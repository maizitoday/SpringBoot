package com.example.demo;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/19 下午3:56
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.dao.slave", sqlSessionTemplateRef = "slaveSqlSessionTemplate")
public class DataSourceSlaveConfig {
	/***
	 * 配置数据源
	 * 
	 * @return
	 */
	@ConfigurationProperties(prefix = "spring.datasource.slave")
	@Bean(name = "slaveDataSource")
	public DataSource slaveDataSource(Environment env) throws SQLException {
		// 这里设置了 Druid创建数据源
		// DruidDataSource xaDataSource = DruidDataSourceBuilder.create().build();


		AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
		xaDataSource.setUniqueResourceName("slaveDataSource");
		xaDataSource.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
		xaDataSource.setPoolSize(5);
		Properties prop = ProUtil.build(env, "spring.datasource.slave.");
		xaDataSource.setXaProperties(prop);
		return xaDataSource;
	}

	/***
	 * 配置 SqlSessionFactory
	 * 
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "slaveSqlSessionFactory")
	public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/slave/*.xml"));
		return bean.getObject();
	}

	/***
	 * 配置事物： 如果用JTA来处理事物的话，是不需要写事物的
	 * 
	 * @param dataSource
	 * @return
	 */
//	@Bean(name = "slaveTransactionManager")
//	public DataSourceTransactionManager slaveTransactionManager(@Qualifier("slaveDataSource") DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}

	/***
	 * 配置数据库操作模板
	 * 
	 * @param sqlSessionFactory
	 * @return
	 * @throws Exception
	 */
	@Bean(name = "slaveSqlSessionTemplate")
	public SqlSessionTemplate slaveSqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
