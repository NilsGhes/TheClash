package net.nilsghesquiere.datasource;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class DataSourceBean{
	
	@Bean
	@ConfigurationProperties(prefix="h2.datasource")
	public DataSource h2DataSource() {
		DataSource dataSource =  DataSourceBuilder.create().build();
		return dataSource;
		}
	
	/*
	//als dit in commentaar staat word H2 gebruikt
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource firstDataSource() {
		DataSource dataSource =  DataSourceBuilder.create().build();
		return dataSource;
		}
	*/
}

