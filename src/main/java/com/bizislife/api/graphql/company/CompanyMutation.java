package com.bizislife.api.graphql.company;

import com.bizislife.core.dao.pojo.Company;

public interface CompanyMutation {

	public Company newCompany(String realm, String prefername);
}
