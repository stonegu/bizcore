package com.bizislife.api.graphql.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeycloakTokenFull {
	private String access_token;
	private String refresh_token;
	private Integer expires_in;
	private Integer refresh_expires_in;
	private String token_type;
	private String session_state;
	private String scope;

}
