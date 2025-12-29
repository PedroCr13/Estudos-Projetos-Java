package com.hachathon.backend_simulador_api.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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
    basePackages = "com.hachathon.backend_simulador_api.sqlserver.repository",
    entityManagerFactoryRef = "sqlServerEntityManagerFactory",
    transactionManagerRef = "sqlServerTransactionManager"
)
public class SpringDataSQLServerConfig {
	
    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
	
	@Bean
	public DataSource sqlServerDataSource() {
		
		// SQL Server Oficial   
		HikariDataSource ds = new HikariDataSource();
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setJdbcUrl(jdbcUrl);
        ds.setDriverClassName(driverClassName);
        
        return ds;
	}
	
	@Bean(name = "sqlServerEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean sqlServerEntityManagerFactory() {
	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(false);
	    vendorAdapter.setShowSql(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setDataSource(sqlServerDataSource());
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.hachathon.backend_simulador_api.entity.sqlserver");
	    factory.setPersistenceUnitName("sqlServerPU");

	    return factory;
	}

    
	@Bean(name = "sqlServerTransactionManager")
	public PlatformTransactionManager sqlServerTransactionManager(
	        @Qualifier("sqlServerEntityManagerFactory") EntityManagerFactory emf) {
	    JpaTransactionManager manager = new JpaTransactionManager();
	    manager.setEntityManagerFactory(emf);
	    manager.setJpaDialect(new HibernateJpaDialect());
	    return manager;
	}
}
