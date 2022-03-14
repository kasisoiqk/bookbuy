package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity extends BaseEntity {
	
	@Column(nullable = false)
	private Long customerId;
	
	@Column
	private int status;
	
	@Column
	private Long totalPrice;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bill")
	private List<BillInfoEntity> billsInfo = new ArrayList<>();

	public BillEntity() {
		super();
	}

	public BillEntity(Long customerId, int status, Long totalPrice) {
		super();
		this.customerId = customerId;
		this.status = status;
		this.totalPrice = totalPrice;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<BillInfoEntity> getBillsInfo() {
		return billsInfo;
	}

	public void setBillsInfo(List<BillInfoEntity> billsInfo) {
		this.billsInfo = billsInfo;
	}

}
