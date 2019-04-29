package com.bizislife.core.utils;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;

import org.apache.http.auth.AuthenticationException;
import org.junit.Test;

import com.bizislife.configuration.KeycloakConfig;

import io.jsonwebtoken.Claims;

public class TokenUtilsTest {
	
	private String clientToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJRZTVBTmFWYzZHRFRmSy1UcktHclZzeVpQTHplMjFNbkRXdmotWm5IYjdNIn0.eyJqdGkiOiI1ZTEwNjE4NS1lYWQ4LTQ0MTktYTZjOC1iMTY1Y2YwMjJjMzUiLCJleHAiOjE1NTUxNzY4NjYsIm5iZiI6MCwiaWF0IjoxNTU1MTc1NjY2LCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODEvYXV0aC9yZWFsbXMvQklaIiwiYXVkIjpbInJlYWxtLW1hbmFnZW1lbnQiLCJhY2NvdW50Il0sInN1YiI6IjdkNGE2MDU4LTY4ZWMtNGFlMy05OTNiLTAzYzBkMWMzMjdiNCIsInR5cCI6IkJlYXJlciIsImF6cCI6Ik1PQklMRSIsImF1dGhfdGltZSI6MCwic2Vzc2lvbl9zdGF0ZSI6IjQ5ZWE3OGJiLTViYzUtNGFjMC05YzYxLTEyNjNkZjU5NGI0MSIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7InJlYWxtLW1hbmFnZW1lbnQiOnsicm9sZXMiOlsidmlldy1pZGVudGl0eS1wcm92aWRlcnMiLCJ2aWV3LXJlYWxtIiwibWFuYWdlLWlkZW50aXR5LXByb3ZpZGVycyIsImltcGVyc29uYXRpb24iLCJyZWFsbS1hZG1pbiIsImNyZWF0ZS1jbGllbnQiLCJtYW5hZ2UtdXNlcnMiLCJxdWVyeS1yZWFsbXMiLCJ2aWV3LWF1dGhvcml6YXRpb24iLCJxdWVyeS1jbGllbnRzIiwicXVlcnktdXNlcnMiLCJtYW5hZ2UtZXZlbnRzIiwibWFuYWdlLXJlYWxtIiwidmlldy1ldmVudHMiLCJ2aWV3LXVzZXJzIiwidmlldy1jbGllbnRzIiwibWFuYWdlLWF1dGhvcml6YXRpb24iLCJtYW5hZ2UtY2xpZW50cyIsInF1ZXJ5LWdyb3VwcyJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19LCJNT0JJTEUiOnsicm9sZXMiOlsidW1hX3Byb3RlY3Rpb24iXX19LCJzY29wZSI6InByb2ZpbGUgZW1haWwiLCJjbGllbnRIb3N0IjoiMTI3LjAuMC4xIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJjbGllbnRJZCI6Ik1PQklMRSIsInByZWZlcnJlZF91c2VybmFtZSI6InNlcnZpY2UtYWNjb3VudC1tb2JpbGUiLCJjbGllbnRBZGRyZXNzIjoiMTI3LjAuMC4xIiwiZW1haWwiOiJzZXJ2aWNlLWFjY291bnQtbW9iaWxlQHBsYWNlaG9sZGVyLm9yZyJ9.hCQ4dmKFBhq_ZAjDvT2rlkDPll6hhZCaeNsdkvZdN0WeIn82vcGKk0cogMOgOxWZwtmVbUDwrAnmfjE6bofHXOsih2DiuHGsteNjXlMke35OTf-UmOPlNVciTQWp-cIyo4PuROYOSZKDkhkMf3de30pk6CgMnJt3PKzFiNbtuAj1pyXKZt8DSSKxcJXrxbWyoadMIR3Ei9i4tqB3lhXkrHNWvBdQiJZoY1hwflNJAytP3g-OlgxtQDK7E3kiJDoFp7xAP_QgnzerA59SiRbsOe9SgxcfiKHLTI8_8TlUwh4GG4WALc1azhYPR3zZUOpQbQ6FiRaROQlFsjT6V4t_WQ";
	private String userToken = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJpZCIsImlhdCI6MTU1NTcyNTM2Mywic3ViIjoic3ViamVjdCIsImlzcyI6Imlzc3VlciIsImV4cCI6MTU1NjcyNTM2M30.FRp-O8IQ1PCG1eV1cISzRA-Z912KWWXp9yA1XUFGZo0";
	private String secret = "secretKey";
	
    @Test
    public void parseToken() throws AuthenticationException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
//    	KeycloakConfig config = new KeycloakConfig();
//    	config.setRealm("BIZ");
//    	config.setResource("MOBILE");
    	Claims claims = TokenUtils.parseTokenWithKey(userToken, secret);
    	System.out.println("");
    }
    
    @Test
    public void createJWT() {
    	String token = TokenUtils.createJWT("id", "issuer", "subject", 1000000000, "secretKey");
    	System.out.println("token: " + token);
    }
	

}
