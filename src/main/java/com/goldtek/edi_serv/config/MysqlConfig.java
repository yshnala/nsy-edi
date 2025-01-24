package com.goldtek.edi_serv.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.goldtek.edi_serv.repostory.edi", // MySQL的repository所在包
    entityManagerFactoryRef = "mysqlEntityManagerFactory",
    transactionManagerRef = "mysqlTransactionManager"
)
public class MysqlConfig {
	  @Bean
	    @ConfigurationProperties(prefix = "spring.datasource.edi")
	    public DataSource mysqlDataSource() {
	        return DataSourceBuilder.create()
	                .type(HikariDataSource.class)
	                .build();
	    }

	    @Bean
	    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(
	            EntityManagerFactoryBuilder builder,
	            @Qualifier("mysqlDataSource") DataSource dataSource) {
	        
	        Map<String, String> properties = new HashMap<>();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	        
	        return builder
	                .dataSource(dataSource)
	                .packages("com.goldtek.edi_serv.entity.edi")
	                .properties(properties)
	                .persistenceUnit("edi")
	                .build();
	    }

	    @Bean
	    public PlatformTransactionManager mysqlTransactionManager(
	            @Qualifier("mysqlEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
	        return new JpaTransactionManager(entityManagerFactory);
	    }

}