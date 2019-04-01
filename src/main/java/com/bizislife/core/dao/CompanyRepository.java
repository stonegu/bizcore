package com.bizislife.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bizislife.core.dao.pojo.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

}
