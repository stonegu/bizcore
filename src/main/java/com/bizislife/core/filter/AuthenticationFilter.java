package com.bizislife.core.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Order(1)
public class AuthenticationFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		log.info("this is filter");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		Enumeration<String> headerNames = httpRequest.getHeaderNames();
		
	    if (headerNames != null) {
	        while (headerNames.hasMoreElements()) {
	            String name = headerNames.nextElement();
	            System.out.println("Header: " + name + " value:" + httpRequest.getHeader(name));
	        }
	    }

		chain.doFilter(request, response);
		
	}

}
