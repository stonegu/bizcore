package com.bizislife.api.graphql.authentication;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bizislife.configuration.KeycloakConfig;
import com.bizislife.rest.component.KeycloakToken;
import com.bizislife.rest.component.KeycloakTokenFull;
import com.bizislife.rest.utils.AuthenUtils;
import com.bizislife.rest.utils.HttpUtils;

@Component
public class KeycloakAuthenQueryImpl implements KeycloakAuthenQuery {

	@Value("${clientHttp.timeout}")
	private int timeout;
	
	@Autowired
	KeycloakConfig keycloakConfig;

	@Override
	public KeycloakToken keycloakAuthentication(String username, String password, String realm, String client) throws RestClientException, UnsupportedEncodingException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add("Authorization", AuthenUtils.createSecureHeader(keycloakConfig.getResource(), keycloakConfig.getCredentials().getSecret()));
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("username", username);
		map.add("password", password);
		map.add("grant_type", "password");
		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
		
		ClientHttpRequestFactory clientHttpRequestFactory = HttpUtils.getClientHttpRequestFactory(timeout);
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

		KeycloakTokenFull token = restTemplate.postForObject("http://localhost:8081/auth/realms/BIZ/protocol/openid-connect/token", request, KeycloakTokenFull.class);
		
		return new KeycloakToken(token.getAccess_token(), token.getRefresh_token());
	}

}
