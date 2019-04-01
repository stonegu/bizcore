package com.bizislife.api.graphql.company;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.bizislife.core.dao.pojo.Company;
import com.bizislife.core.service.CompanyService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component("companyMutation")
public class CompanyMutationImpl implements CompanyMutation, GraphQLMutationResolver {
	
	@Autowired
	private CompanyService companyService;

	@Override
	public Company newCompany(String realm, String prefername) {
		Locale locale = LocaleContextHolder.getLocale();
		Company company = new Company();
		company.setPrefername(prefername);
		company.setRealmid(realm);
		companyService.add(company, locale);
		
		return null;
	}

}
