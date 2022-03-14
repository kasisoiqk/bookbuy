package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Column
	private String name;
	
	@Column
	private String code;

	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public RoleEntity() {
		super();
	}

	public RoleEntity(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
