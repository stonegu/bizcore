package com.bizislife.core.utils;

import java.security.PublicKey;

import javax.security.auth.message.AuthException;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.auth.AuthenticationException;

import com.bizislife.api.graphql.configuration.KeycloakConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenUtils {
	public static Claims parseToken(String token) throws AuthenticationException {
		if (token == null) {
			throw new AuthenticationException("token is missing");
		}		
		return Jwts.parser().parseClaimsJws(getTokenWithoutSignature(extractBearer(token))).getBody();
	}
	
	public static Claims parseToken2(PublicKey key, String token) throws AuthenticationException {
		if (token == null) {
			throw new AuthenticationException("token is missing");
		}
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	}
	
	public static Claims parseToken3(PublicKey key, String token, KeycloakConfig keycloakConfig) throws AuthenticationException {
		if (token == null) {
			throw new AuthenticationException("token is missing");
		}
		return Jwts.parser().setSigningKey(key)
				.requireAudience(keycloakConfig.getResource())
				.requireIssuer(keycloakConfig.getRealm()).parseClaimsJws(token).getBody();
		
	}
	
    public static String getTokenWithoutSignature(String encodedToken) {
        int i = encodedToken.lastIndexOf('.');
        return encodedToken.substring(0, i + 1);
    }
    
    public static String extractBearer(String token) {
        return StringUtils.removeStartIgnoreCase(token, "Bearer ");
    }
    
}
