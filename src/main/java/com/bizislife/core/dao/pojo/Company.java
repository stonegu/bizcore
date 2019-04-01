package com.bizislife.core.dao.pojo;

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
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String realmid;
	private String prefername;
	private String registname;
}
