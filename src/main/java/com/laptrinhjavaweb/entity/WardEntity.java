package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vn_ward")
public class WardEntity extends BaseEntity {

	@Column(length = 5)
	private String maxp;
	
	@Column
	private String name;
	
	@Column
	private String type;

	@Column(length = 5)
	private String maqh;

	public String getMaqh() {
		return maqh;
	}

	public String getMaxp() {
		return maxp;
	}

	public void setMaxp(String maxp) {
		this.maxp = maxp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMaqh(String maqh) {
		this.maqh = maqh;
	}
	
}
