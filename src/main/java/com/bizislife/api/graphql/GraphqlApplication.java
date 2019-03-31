package com.bizislife.api.graphql;

import com.bizislife.api.graphql.configuration.JDBCConfig;
import com.bizislife.api.graphql.configuration.KeycloakConfig;
import com.bizislife.api.graphql.configuration.YAMLBaseConfig;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class GraphqlApplication implements CommandLineRunner{
	
	@Autowired
	private YAMLBaseConfig yamlBaseConfig;

	@Autowired
	private JDBCConfig jdbcConfig;

	@Autowired
	private KeycloakConfig keycloakConfig;
	
	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
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
		System.out.println("realm: " + keycloakConfig.getRealm());
		System.out.println("auth-server-url: " + keycloakConfig.getAuthServerUrl());
		System.out.println("secret: " + keycloakConfig.getCredentials().getSecret());
	}
}

