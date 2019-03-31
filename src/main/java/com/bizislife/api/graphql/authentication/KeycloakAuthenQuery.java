package com.bizislife.api.graphql.authentication;

import java.io.UnsupportedEncodingException;

import org.springframework.web.client.RestClientException;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public interface KeycloakAuthenQuery extends GraphQLQueryResolver{
	public KeycloakToken keycloakAuthentication(String username, String password, String realm, String client) throws RestClientException, UnsupportedEncodingException;

}
