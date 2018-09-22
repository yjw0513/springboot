package com.yjw.spring.springboot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = "com.yjw.spring.springboot.dao.mapper", sqlSessionFactoryRef = "sessionFactory")
public class MybatisConfig {
	// Environment
	// 接口，表示当前应用程序正在运行的环境。应用程序环境的两个关键方面:
	// 概要文件和属性。与属性访问相关的方法通过PropertyResolver超接口公开。
	@Autowired
	private Environment env;
	/**
	 * @Title: defaultDataSource
	 * @Description: 创建数据源
	 * @return DataSource
	 * 
	 */
	// @Primary
	// 表示当多个候选对象具备自动连接单值依赖项的条件时，应该优先考虑bean。
	// 如果候选对象中只有一个“主”bean，那么它将是自动连接的值。
	@Primary
	@Bean(name = "dataSource")
	public DataSource dataSource() {
		// 使用DruidDataSource数据源
		DruidDataSource dataSources = new DruidDataSource();
		// 获取驱动
		dataSources.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		// 获取访问路径
		dataSources.setUrl(env.getProperty("spring.datasource.url"));
		// 获取用户名
		dataSources.setUsername(env.getProperty("spring.datasource.username"));
		// 获取用户密码
		dataSources.setPassword(env.getProperty("spring.datasource.password"));
		return dataSources;
	}

	/**
	 * @Title: sessionFactory
	 * @Description: 获取session工厂
	 * @param: @param dataSource 数据源
	 * @param: @return
	 * @return: SqlSessionFactory
	 * @throws
	 * 
	 */

	@Primary
	@Bean(name = "sessionFactory")
	public SqlSessionFactory sessionFactory(@Qualifier("dataSource") DataSource dataSource) {
		SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			// resolver.getResources------将给定的位置模式解析为资源对象。
			// 设置将在运行时合并到SqlSessionFactory配置中的MyBatis映射文件的位置。
     		// sessionFactoryBean.setMapperLocations
			// 这是在MyBatis配置文件中指定“< sqlmapper >”条目的替代方法。这个基于
			// Spring资源抽象的属性还允许在这里指定资源模式:例如:“classpath *:sqlmap / * -mapper.xml”。
			sessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:sqlmap/*.xml"));
			// 返回一个实例对象的(可能共享或独立)由这个工厂管理。
			return sessionFactoryBean.getObject();
		} catch (Exception e) {
			System.out.println("mybatis初始化sqlSessionFactoryBean失败");
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * ---------该方法可省略-------------
	 * @Title: sqlSessionTemplate
	 * @Description: TODO(创建实例工厂)
	 * @param: @param sqlSessionFactory
	 * @return: SqlSessionTemplate
	 * @throws
	 * 
	 */
	@Primary
	@Bean("defaultSqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		// 构造一个Spring管理的SqlSession，并将SqlSessionFactory作为参数提供。
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
