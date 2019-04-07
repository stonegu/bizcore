package com.bizislife.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bizislife.core.dao.pojo.ProspectingCompany;

@Repository
public interface ProspectingCompanyRepository extends JpaRepository<ProspectingCompany, String> {
}
