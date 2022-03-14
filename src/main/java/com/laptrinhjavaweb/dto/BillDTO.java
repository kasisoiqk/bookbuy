package com.laptrinhjavaweb.dto;

public class BillDTO {

	private Long id;
	private Long customerId;
	private int status; // 0 - Chờ xác nhận | 1 - Đã đóng gói | 2 - Đang vận chuyển | 3 - Đã giao | 4 - Đã hủy
	private Long totalPrice;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
}
