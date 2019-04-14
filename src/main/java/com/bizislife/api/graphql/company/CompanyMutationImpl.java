package com.bizislife.api.graphql.company;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.bizislife.core.service.CompanyService;
import com.bizislife.core.utils.BizAccess;
import com.bizislife.core.utils.GuestAccess;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component("companyMutation")
public class CompanyMutationImpl implements CompanyMutation, GraphQLMutationResolver {
	
	@Autowired
	private CompanyService companyService;

	@Override
	@BizAccess
	@GuestAccess
	public String regist(String registCode) {
		Locale locale = LocaleContextHolder.getLocale();
		
		String companyId = companyService.register(registCode, locale);
		
		return companyId;
	}

}
