package com.bizislife.core.service.impl;

import java.util.Locale;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Service;

import com.bizislife.core.dao.CompanyRepository;
import com.bizislife.core.dao.pojo.Company;
import com.bizislife.core.service.CompanyService;

import lombok.RequiredArgsConstructor;

@Service("CompanyService")
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private MessageSource messageSource;

	
	@Override
	public String add(Company company, Locale locale) {
		if (companyRepository.existsById(company.getId())) {
			throw new EntityExistsException(messageSource.getMessage("entity.exist", null, locale));
		} else {
//			companyRepository.save(company);
//			return company.getId();
			throw new EntityExistsException(messageSource.getMessage("entity.exist", null, locale));
		}
	}
	
}
