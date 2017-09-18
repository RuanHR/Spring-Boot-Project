package com.pactera.base.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.github.pagehelper.PageHelper;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @ClassName: MybatisConfigurer 
 * @date 2017年9月18日 下午12:12:48 
 * @author ToniR  
 * @Description: Mybatis & Mapper & PageHelper 配置
 */
@Configuration
public class MybatisConfigurer {
	@Resource
	private DataSource dataSource;

	@Bean
	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setTypeAliasesPackage("com.pactera.biz.bean");

		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);

		// 添加插件
		bean.setPlugins(new Interceptor[] { pageHelper });

		// 添加XML目录
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
		return bean.getObject();
	}

	@Configuration
	@AutoConfigureAfter(MybatisConfigurer.class)
	public static class MyBatisMapperScannerConfigurer {

		@Bean
		public MapperScannerConfigurer mapperScannerConfigurer() {
			MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
			mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
			mapperScannerConfigurer.setBasePackage("com.pactera.business.mapper");
			// 配置通用mappers
			Properties properties = new Properties();
			properties.setProperty("mappers", "com.pactera.base.core.Mapper");
			properties.setProperty("notEmpty", "false");
			properties.setProperty("IDENTITY", "MYSQL");
			mapperScannerConfigurer.setProperties(properties);

			return mapperScannerConfigurer;
		}

	}
}