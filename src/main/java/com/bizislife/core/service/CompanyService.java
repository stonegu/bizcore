package com.bizislife.core.service;

import java.util.Locale;

import com.bizislife.core.dao.pojo.Company;
import com.bizislife.core.dao.pojo.ProspectingCompany;

public interface CompanyService {
	String register(String registCode, Locale locale);
	ProspectingCompany getProspectingCompanyById(String id);
	
}
