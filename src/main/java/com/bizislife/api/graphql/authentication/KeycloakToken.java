package com.bizislife.api.graphql.authentication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KeycloakToken {
	private String accessToken;
	private String refreshToken;
}
