package com.geoxus.config;

import com.geoxus.entities.Person;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

//@Configuration
@EnableTransactionManagement
@ComponentScan("com.geoxus")
public class AppConfig {
	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("枫叶思源");
		person.setAge(100);
		return person;
	}

	@Bean
	public ComboPooledDataSource dataSource( ) throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("britton");
		dataSource.setPassword("britton");
		dataSource.setJdbcUrl("jdbc:mysql://192.168.56.101:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf8&tinyInt1isBit=false");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setInitialPoolSize(200);
		dataSource.setMaxPoolSize(2000);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate( dataSource);
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
		return  new DataSourceTransactionManager(dataSource);
	}
}
