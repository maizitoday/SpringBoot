//package com.example.demo;
//
//import javax.transaction.TransactionManager;
//import javax.transaction.UserTransaction;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.DependsOn;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.jta.JtaTransactionManager;
//
//import com.atomikos.icatch.jta.UserTransactionImp;
//import com.atomikos.icatch.jta.UserTransactionManager;
///**
// * @author yubo
// * @version V2.0
// * @Description:
// * @date 2018/7/25 下午4:01
// * @Company: cecsm.com
// * @Copyright Copyright (c) 2017
// */
//@Configuration
//@EnableTransactionManagement
//public class XATransactionManagerConfig {
//
//    /**
//     * MyBatis自动参与到spring事务管理中，无需额外配置，只要org.mybatis.spring.SqlSessionFactoryBean引用的数据源与DataSourceTransactionManager引用的数据源一致即可，否则事务管理会不起作用。
//     * @return
//     * @throws Throwable
//     */
//	@Bean(name = "userTransaction")
//	public UserTransaction userTransaction() throws Throwable {
//		UserTransactionImp userTransactionImp = new UserTransactionImp();
//		userTransactionImp.setTransactionTimeout(10000);
//		return userTransactionImp;
//	}
//
//	@Bean(name = "atomikosTransactionManager", initMethod = "init", destroyMethod = "close")
//	public TransactionManager atomikosTransactionManager() throws Throwable {
//		UserTransactionManager userTransactionManager = new UserTransactionManager();
//		userTransactionManager.setForceShutdown(false);
//		return userTransactionManager;
//	}
//
//
//	@Bean(name = "transactionManager")
//	@DependsOn({"userTransaction", "atomikosTransactionManager"})
//	public PlatformTransactionManager transactionManager() throws Throwable {
//		return new JtaTransactionManager(userTransaction(), atomikosTransactionManager());
//	}
//}
