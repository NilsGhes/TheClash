package net.nilsghesquiere.datasource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class CreateDataSourceBeans{
	/*
	//als dit in commentaar staat word H2 gebruikt
	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource firstDataSource() {
		DataSource dataSource =  DataSourceBuilder.create().build();
		return dataSource;
		}
	*/
}

