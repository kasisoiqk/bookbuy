package com.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@CreatedDate
	private Date createDate;
	
	@Column
	@CreatedBy 
	private String createBy;
	
	@Column
	@LastModifiedDate
	private Date moditiedDate;
	
	@Column
	@LastModifiedBy
	private String moditiedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getModitiedDate() {
		return moditiedDate;
	}

	public void setModitiedDate(Date moditiedDate) {
		this.moditiedDate = moditiedDate;
	}

	public String getModitiedBy() {
		return moditiedBy;
	}

	public void setModitiedBy(String moditiedBy) {
		this.moditiedBy = moditiedBy;
	}

}
