package com.bizislife.api.graphql.company;

import com.bizislife.core.dao.pojo.Company;

public interface CompanyMutation {

	
	/**
	 * 
	 * @param registCode: the UUID code send in email, which code can be used to gnerate a new company in the system. This code is the ID in CompanyPond.java
	 * @return companyId
	 */
	public String regist(String registCode);
}
