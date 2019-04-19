package com.bizislife.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "keycloak")
@Getter
@Setter
public class KeycloakConfig {
	private String realm;
	private String authServerUrl;
	private String sslRequired;
	private String resource;
	private Boolean verifyTokenAudience;
	private Credentials credentials;
	private Integer confidentialPort;
	
	@Getter
	@Setter
	public static class Credentials {
		private String secret;
	}
	
}
