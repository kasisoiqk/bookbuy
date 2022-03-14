package com.laptrinhjavaweb.dto;

import java.util.List;

public class OrderDTO {
	public Long id;
	public List<BillInfoDTO> carts;
	public CustometDTO customer;
	public Long totalPayment;
	public int status;
}