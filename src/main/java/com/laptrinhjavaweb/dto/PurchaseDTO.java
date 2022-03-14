package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class PurchaseDTO {
	
	public List<BillInfoDTO> purchases;
	public CustometDTO customer;
	
	public PurchaseDTO() {
		purchases = new ArrayList<>();
	}
	
}
