package com.bizislife.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:application-jdbc.yml")
@EnableConfigurationProperties
@ConfigurationProperties (prefix = "spring.datasource")
@Getter
@Setter
public class JDBCConfig {
    private String driverClassName;
    private String url;
//    private String loginname;
//    private String password;
}
