package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.BillInfoDTO;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.PurchaseDTO;
import com.laptrinhjavaweb.entity.BillEntity;
import com.laptrinhjavaweb.entity.BillInfoEntity;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.mapper.BillInfoMapper;
import com.laptrinhjavaweb.mapper.CustomerMapper;
import com.laptrinhjavaweb.repository.BillInfoRepository;
import com.laptrinhjavaweb.repository.BillRepository;
import com.laptrinhjavaweb.repository.CustomerRepository;
import com.laptrinhjavaweb.service.IPurchaseService;

@Service
public class PurchaseServiceImpl implements IPurchaseService {
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private BillInfoRepository billInfoRepository;

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private BillInfoMapper billInfoMapper;

	@Override
	public Long order(OrderDTO order) {
		// Save customer info
		CustomerEntity customer = customerMapper.convertToEntity(order.customer);
		customer = customerRepository.save(customer);
		
		// Calculator total payment
		Long feeShip = 30000L;
		Long totalPrice = 0L;
		Long totalPayment = 0L;
		
		for (BillInfoDTO book : order.carts) {
			totalPrice += (book.getCurrentPrice() * book.getQuantity());
		}
		totalPayment = totalPrice + feeShip;
		
		// Create new bill in database
		BillEntity bill = new BillEntity();
		bill.setCustomerId(customer.getId());
		bill.setStatus(0);
		bill.setTotalPrice(totalPayment);
		bill = billRepository.save(bill);
		
		// Save list books on BillInfo table
		for (BillInfoDTO book : order.carts) {
			BillInfoEntity billInfo = new BillInfoEntity();
			billInfo.setBill(bill);
			billInfo.setBookId(book.getId());
			billInfo.setPrice(book.getCurrentPrice());
			billInfo.setQuantity(book.getQuantity());
			billInfoRepository.save(billInfo);
		}
		return bill.getId();
	}

	@Override
	public PurchaseDTO getListPurchase(Long id) {
		PurchaseDTO purchases = new PurchaseDTO();
		
		// Get list purchases
		BillEntity bill = billRepository.findOne(id);
		if(bill == null) return purchases;
		List<BillInfoEntity> billInfoEntities = billInfoRepository.findByBill(bill);
		for (BillInfoEntity billInfo : billInfoEntities) {
			purchases.purchases.add(billInfoMapper.convertToDTO(billInfo));
		}
		
		// Get customer info
		CustomerEntity customer = customerRepository.findOne(bill.getCustomerId());
		if(customer == null) return purchases;
		purchases.customer = customerMapper.convertToDTO(customer);
		return purchases;
	}

	@Override
	public String cancelPurchase(Long id) {
		BillEntity bill = billRepository.findOne(id);
		if(bill == null) return "error";
		if(bill.getStatus() >= 2) return "cannot be canceled";
		bill.setStatus(4);
		billRepository.save(bill);
		return "success";
	}

	@Override
	public List<OrderDTO> getAllOrders() {
		List<OrderDTO> result = new ArrayList<>();
		List<BillEntity> bills = billRepository.findAll();
		for (BillEntity bill : bills) {
			OrderDTO order = new OrderDTO();
			order.carts = new ArrayList<>();
			order.id = bill.getId();
			order.status = bill.getStatus();
			order.totalPayment = bill.getTotalPrice();
			for (BillInfoEntity billInfo : bill.getBillsInfo()) {
				order.carts.add(billInfoMapper.convertToDTO(billInfo));
			}
			CustomerEntity customer = customerRepository.findOne(bill.getCustomerId());
			order.customer = customerMapper.convertToDTO(customer);
			result.add(order);
		}
		return result;
	}

	@Override
	public boolean changeStatus(Long id) {
		BillEntity bill = billRepository.findOne(id);
		if(bill.getStatus() < 3) {
			bill.setStatus(bill.getStatus()+1);
			billRepository.save(bill);
			return true;
		}
		else if(bill.getStatus() >= 4) {
			bill.setStatus(0);
			billRepository.save(bill);
			return true;
		}
		return false;
	}

}
