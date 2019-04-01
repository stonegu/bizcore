package com.bizislife.core.service;

import java.util.Locale;

import com.bizislife.core.dao.pojo.Company;

public interface CompanyService {
	String add(Company company, Locale locale);
}
