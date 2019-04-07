package com.bizislife.core.dao.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class ProspectingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String name;
	private String email;
	private String phone;
	private String realmid;
	private Date registrationdate;

}
