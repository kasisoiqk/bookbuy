package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "billinfo")
public class BillInfoEntity extends BaseEntity {
	
	@Column
	private Long bookId;
	
	@Column
	private Long quantity;
	
	@Column
	private Long price;
	
	@ManyToOne
	@JoinColumn(name = "bill_id", nullable = false)
	private BillEntity bill;

	public BillInfoEntity() {
		super();
	}

	public BillInfoEntity(Long bookId, Long quantity, Long price) {
		super();
		this.bookId = bookId;
		this.quantity = quantity;
		this.price = price;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}
	
}
