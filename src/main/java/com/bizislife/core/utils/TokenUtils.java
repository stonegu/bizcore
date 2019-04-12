package com.bizislife.core.utils;

import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.message.AuthException;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.auth.AuthenticationException;

import com.bizislife.api.graphql.configuration.KeycloakConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

public class TokenUtils {
	public static Claims parseToken(String token) throws AuthenticationException {
		if (token == null) {
			throw new AuthenticationException("token is missing");
		}		
		return Jwts.parser().parseClaimsJwt(getTokenWithoutSignature(extractBearer(token))).getBody();
	}
	
	public static Claims parseToken2(String key, String token) throws AuthenticationException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
		if (token == null) {
			throw new AuthenticationException("token is missing");
		}
		PublicKey pkey = getPublicKey(key, "RSA", "BC");
		return Jwts.parser().setSigningKey(pkey).parseClaimsJwt(getTokenWithoutSignature(extractBearer(token))).getBody();
	}
	
	public static Claims parseToken3(PublicKey key, String token, KeycloakConfig keycloakConfig) throws AuthenticationException {
		if (token == null) {
			throw new AuthenticationException("token is missing");
		}
		return Jwts.parser().setSigningKey(key)
				.requireAudience(keycloakConfig.getResource())
				.requireIssuer(keycloakConfig.getRealm())
				.parseClaimsJwt(getTokenWithoutSignature(extractBearer(token))).getBody();
		
	}
	
	public static Claims parseToken4(String jwt, String secretKey) {
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser()
	            .setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
	            .parseClaimsJws(jwt).getBody();
	    return claims;
	}	
	
	public static Claims parseToken5(String jwt, String secretKey) {
	    //This line will throw an exception if it is not a signed JWS (as expected)
	    Claims claims = Jwts.parser()
	            .setSigningKey(TextCodec.BASE64.decode(secretKey))
	            .parseClaimsJws(jwt).getBody();
	    return claims;
	}	

	public static String getTokenWithoutSignature(String encodedToken) {
        int i = encodedToken.lastIndexOf('.');
        return encodedToken.substring(0, i + 1);
    }
    
    public static String extractBearer(String token) {
        return StringUtils.removeStartIgnoreCase(token, "Bearer ");
    }
    
    public static PublicKey getPublicKey(String key, String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
        byte[] decodedKey = Base64.decodeBase64(key);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(decodedKey);
        KeyFactory kf = KeyFactory.getInstance(algorithm, provider);
        return kf.generatePublic(spec);    }
    
    
    public static String createJWT(String id, String issuer, String subject, long ttlMillis, String secretKey) {
    	
		/*    	
		    	
String jws = Jwts.builder()
  .setIssuer("Stormpath")
  .setSubject("msilverman")
  .claim("name", "Micah Silverman")
  .claim("scope", "admins")
  // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
  .setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
  // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
  .setExpiration(Date.from(Instant.ofEpochSecond(4622470422L)))
  .signWith(
    SignatureAlgorithm.HS256,
    TextCodec.BASE64.decode("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=")
  )
  .compact();		    	
		    	
		*/    	
    	  
        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);
      
        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }  
      
        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }    
    
}
