package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

	@Column
	private String fullName;
	
	@Column
	private String phone;
	
	@Column
	private String infoExtra;
	
	@Column
	private String number;
	
	@Column
	private String ward;
	
	@Column
	private String district;
	
	@Column 
	private String province;

	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String fullName, String phone, String infoExtra, String number, String ward, String district,
			String province) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.infoExtra = infoExtra;
		this.number = number;
		this.ward = ward;
		this.district = district;
		this.province = province;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInfoExtra() {
		return infoExtra;
	}

	public void setInfoExtra(String infoExtra) {
		this.infoExtra = infoExtra;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
}
