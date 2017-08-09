package com.srimatha.finance.initializer;

import javax.sql.DataSource;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(value = "com.srimatha.finance")
@EnableWebMvc
@ImportResource("classpath:hibernate.cfg.xml")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class AppConfig {
	@Autowired
	Environment environment;

	@Bean
	public UrlBasedViewResolver urlBasedViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("application");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment
				.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource
				.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource
				.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory
				.setPackagesToScan(new String[] { "com.srimatha.finance.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql",
				environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql",
				environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.default_schema",
				environment.getRequiredProperty("hibernate.default_schema"));
		properties.put("hibernate.hbm2ddl.auto",
				environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}

}

// @Bean
// public TilesViewResolver getTilesViewResolver() {
// TilesViewResolver tilesViewResolver = new TilesViewResolver();
// tilesViewResolver.setViewClass(TilesView.class);
// return tilesViewResolver;
// }
//
// @Bean
// public TilesConfigurer getTilesConfigurer() {
// TilesConfigurer tilesConfigurer = new TilesConfigurer();
// tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/tiles.xml" });
// tilesConfigurer.setCheckRefresh(true);
// return tilesConfigurer;
// }
//

// @Bean
// public DataSource dataSource(){
// DriverManagerDataSource dataSource = new DriverManagerDataSource();
// dataSource.setDriverClassName(env.getRequiredProperty("student.db.driver"));
// dataSource.setUrl(env.getRequiredProperty("student.db.url"));
// dataSource.setUsername(env.getRequiredProperty("student.db.username"));
// dataSource.setPassword(env.getRequiredProperty("student.db.password"));
// return dataSource;
// }
//
// @Bean
// public AnnotationSessionFactoryBean sessionFactory() {
// AnnotationSessionFactoryBean sessionFactory = new
// AnnotationSessionFactoryBean();
// sessionFactory.setDataSource(dataSource());
// sessionFactory.setPackagesToScan(new String[] {
// "org.baeldung.spring.persistence.model" });
// sessionFactory.setHibernateProperties(hibernateProperties());
//
// return sessionFactory;
// }
//
//
// @Bean
// @Autowired
// public HibernateTransactionManager transactionManager(
// SessionFactory sessionFactory) {
//
// HibernateTransactionManager txManager
// = new HibernateTransactionManager();
// txManager.setSessionFactory(sessionFactory);
//
// return txManager;
// }
//
//
// @Bean
// public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
// return new PersistenceExceptionTranslationPostProcessor();
// }

// @Bean
// public JdbcTemplate jdbcTemplate(){
// JdbcTemplate jdbcTemplate = new JdbcTemplate();
// jdbcTemplate.setDataSource(dataSource());
// return jdbcTemplate;
// }
