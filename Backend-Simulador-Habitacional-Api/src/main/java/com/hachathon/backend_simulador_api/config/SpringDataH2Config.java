package com.hachathon.backend_simulador_api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.hachathon.backend_simulador_api.h2.repository",
    entityManagerFactoryRef = "h2EntityManagerFactory",
    transactionManagerRef = "h2TransactionManager"
)

public class SpringDataH2Config {
	 
	@Bean
	public DataSource h2DataSource() {
		
		HikariDataSource ds = new HikariDataSource();
       // ds.setJdbcUrl("jdbc:h2:mem:simulacoes;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"); 
        ds.setJdbcUrl("jdbc:h2:file:/data/h2db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE"); 
		ds.setDriverClassName("org.h2.Driver");
        ds.setUsername("sa");
        ds.setPassword("");
		
        return ds;
	}

	@Bean(name = "h2EntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory() {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);
	    vendorAdapter.setShowSql(true);
	
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setDataSource(h2DataSource());
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.hachathon.backend_simulador_api.entity.h2"); 
	    factory.setPersistenceUnitName("h2PU");
	
	    factory.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    factory.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
	
	    return factory;
	}

	@Bean(name = "h2TransactionManager")
	public PlatformTransactionManager h2TransactionManager(
	        @Qualifier("h2EntityManagerFactory") EntityManagerFactory emf) {
	    JpaTransactionManager manager = new JpaTransactionManager();
	    manager.setEntityManagerFactory(emf);
	    manager.setJpaDialect(new HibernateJpaDialect());
	    return manager;
	}
}
