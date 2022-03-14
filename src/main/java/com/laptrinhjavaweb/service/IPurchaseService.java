package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.PurchaseDTO;

public interface IPurchaseService {
	Long order(OrderDTO order);
	PurchaseDTO getListPurchase(Long id);
	String cancelPurchase(Long id);
	List<OrderDTO> getAllOrders();
	boolean changeStatus(Long id);
}
