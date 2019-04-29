package com.bizislife.application;

import com.bizislife.configuration.JDBCConfig;
import com.bizislife.configuration.KeycloakConfig;
import com.bizislife.configuration.YAMLBaseConfig;
import com.bizislife.core.filter.AuthenticationFilter;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@ComponentScan(basePackages = {"com.bizislife.core", "com.bizislife.api", "com.bizislife.rest", "com.bizislife.configuration"})
@EntityScan(basePackages = {"com.bizislife.core", "com.bizislife.api", "com.bizislife.rest", "com.bizislife.configuration"})
@EnableJpaRepositories(basePackages = {"com.bizislife.core", "com.bizislife.api", "com.bizislife.rest", "com.bizislife.configuration"})
@SpringBootApplication
@Slf4j
public class BizApplication implements CommandLineRunner{
	
	@Autowired
	private YAMLBaseConfig yamlBaseConfig;

	@Autowired
	private JDBCConfig jdbcConfig;

	@Autowired
	private KeycloakConfig keycloakConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(BizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("this is info log");
		log.error("this is error log");
		System.out.println("project name : " + yamlBaseConfig.getName());
		System.out.println("project description : " + yamlBaseConfig.getDescription());
		System.out.println("project version : " + yamlBaseConfig.getVersion());
		System.out.println("url : " + jdbcConfig.getUrl());
		System.out.println("driver: " + jdbcConfig.getDriverClassName());
//		System.out.println("realm: " + keycloakConfig.getRealm());
//		System.out.println("auth-server-url: " + keycloakConfig.getAuthServerUrl());
//		System.out.println("secret: " + keycloakConfig.getCredentials().getSecret());
	}
	
	@Bean
	public FilterRegistrationBean<AuthenticationFilter> autheticationFilter() {
		FilterRegistrationBean<AuthenticationFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new AuthenticationFilter());
		filterRegistrationBean.addUrlPatterns("/api/*");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}
		
//	@Bean
//	public LocaleResolver localeResolver() {
//		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
//		localeResolver.setDefaultLocale(Locale.US);
//		return localeResolver;
//	}
	
//	@Bean
//	public MessageSource messageSource() {
//		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//		messageSource.setBasename("classpath:messages");
//		messageSource.setDefaultEncoding("UTF-8");
//		messageSource.setCacheSeconds(3600); //reload messages every 60 seconds
//		return messageSource;
//	}
	
	
}

