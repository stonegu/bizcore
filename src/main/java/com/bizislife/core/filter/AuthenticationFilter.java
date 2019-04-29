package com.bizislife.core.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.core.ApplicationFilterChain;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.auth.AuthenticationException;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bizislife.core.utils.TokenUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
//		Enumeration<String> headerNames = httpRequest.getHeaderNames();
//		
//	    if (headerNames != null) {
//	        while (headerNames.hasMoreElements()) {
//	            String name = headerNames.nextElement();
//	            System.out.println("Header: " + name + " value:" + httpRequest.getHeader(name));
//	        }
//	    }
	    
//	    Enumeration params = httpRequest.getParameterNames();
//	    while(params.hasMoreElements()){
//	        String paramName = (String)params.nextElement();
//	        System.out.println(paramName + " = " + httpRequest.getParameter(paramName));
//	    }
//	    
//	    if ("POST".equalsIgnoreCase(httpRequest.getMethod())) {
//	    	Scanner scanner = null;
//	    	try {
//	    		scanner = new Scanner(httpRequest.getInputStream(), "UTF-8").useDelimiter("\\A");
//	    	} catch (IOException e) {
//	    		e.printStackTrace();
//	    	}
//	    	System.out.println("body: " + (scanner.hasNext() ? scanner.next() : ""));
//	    }
	    
		
		
//	    String token = httpRequest.getHeader("Authorization");
//		log.info("token from api [" + httpRequest.getMethod() + " : " + httpRequest.getPathInfo() + "] call: " + token);
//		try {
//			Claims claims = TokenUtils.parseTokenWithKey(token, "2f1af6f8-03ac-47ef-b781-5fca8d40325e");
//			List<String> roles = TokenUtils.getRealmRoles(claims);
//			if (!CollectionUtils.containsAny(roles, "api")) {
//				throw new JwtException("no realm role [api] for user: " + claims.get("name"));
//			}
//			
//		} catch (AuthenticationException e) {
//			// TODO Auto-generated catch block
//			log.error(e.getMessage());
//			throw new JwtException(e.getMessage());
//		}
//	    
		chain.doFilter(request, response);
	}

}
