package com.bizislife.rest.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bizislife.core.service.CompanyService;
import com.bizislife.core.utils.BizAccess;
import com.bizislife.core.utils.GuestAccess;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;



@RestController
@RequestMapping("/company")
class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	
	/**
	 * 
	 * @param registCode: the UUID code send in email, which code can be used to gnerate a new company in the system. 
	 * This code is the ID in CompanyPond.java
	 * @return companyId
	 */
	@PostMapping("/{registCode}")
	@ResponseStatus(HttpStatus.CREATED)
	@BizAccess
	@GuestAccess
	@PreAuthorize("hasAnyAuthority('ROLE_USER')")	
	public String regist(@PathVariable String registCode) {
		Locale locale = LocaleContextHolder.getLocale();
		String companyId = companyService.register(registCode, locale);
		return companyId;
	}

}
