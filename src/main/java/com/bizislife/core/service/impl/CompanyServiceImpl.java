package com.bizislife.core.service.impl;

import java.util.Locale;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.bizislife.core.dao.ProspectingCompanyRepository;
import com.bizislife.api.graphql.utils.AuthenUtils;
import com.bizislife.core.dao.CompanyRepository;
import com.bizislife.core.dao.pojo.Company;
import com.bizislife.core.dao.pojo.ProspectingCompany;
import com.bizislife.core.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private ProspectingCompanyRepository prospectingCompanyRepository;
	
	@Autowired
	private MessageSource messageSource;

	
	@Override
	public String register(String registCode, Locale locale) {
		ProspectingCompany prospectingCompany = getProspectingCompanyById(registCode);
		if (prospectingCompany == null) {
			throw new EntityNotFoundException(
					messageSource.getMessage("err.company.regist.pros.not.found", 
							new Object[] {registCode}, 
							locale));
		}
		
		if (prospectingCompany.getRealmid() != null) {
			throw new EntityExistsException(
					messageSource.getMessage("err.company.regist.pros.registed", 
							new Object[] {registCode}, 
							locale));

		}
		
		// create a new Realm in keycloak, and return realmId
		
		
		// create company
		Company company = new Company();
		company.setPrefername(prospectingCompany.getName());
		
		
		
		companyRepository.save(company);
		return company.getId();
	}


	@Override
	public ProspectingCompany getProspectingCompanyById(String id) {
		return prospectingCompanyRepository.getOne(id);
	}
	
	private String createRealm(String realmId, String realmName) {
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//		headers.add("Authorization", AuthenUtils.createSecureHeader(keycloakConfig.getResource(), keycloakConfig.getCredentials().getSecret()));
		
		
		return realmId;
	}
	
	
}
