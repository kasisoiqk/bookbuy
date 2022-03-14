package com.laptrinhjavaweb.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.service.IPurchaseService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@RestController(value = "purchaseAPIOfAdmin")
@RequestMapping(value = {"/admin/api"})
public class PurchaseAPI {
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@GetMapping(value = {"/list-purchases"})
	public ResponseEntity<?> getListPurchase() {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				List<OrderDTO> result = purchaseService.getAllOrders();
				return result.isEmpty() ?
						ResponseEntity.ok(
								new ResponseMessage("OK", "Data orders is empty!", null)
							) :
						ResponseEntity.ok(
								new ResponseMessage("OK", "Data orders has been taken!", result)
							);
			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not author")
			);
	}
	
	@PutMapping(value = {"/purchase"})
	public ResponseEntity<?> changeStatus(@RequestParam(required = false, defaultValue = "0", value = "id") Long id) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				return purchaseService.changeStatus(id) ? 
						ResponseEntity.status(HttpStatus.OK).body(
								new ResponseMessage("OK", "Order has been changed status!", "success")
							):
						ResponseEntity.status(HttpStatus.OK).body(
								new ResponseMessage("FAILED", "Order can't be changed status!", "can't")
							);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "You are not admin!", "not authen")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not author")
			);
	}
	
	@DeleteMapping(value = {"/purchase"})
	public ResponseEntity<?> cancelPurchase(@RequestParam(required = false, defaultValue = "0", value = "id") Long id) {
		if(SecurityUtils.isAuthentication()) {
			if(SecurityUtils.isADMIN()) {
				return ResponseEntity.status(HttpStatus.OK).body(
						new ResponseMessage("OK", "", purchaseService.cancelPurchase(id))
					);
			}
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseMessage("FAILED", "You are not admin!", "not authen")
				);
		}
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage("FAILED", "You are not logged in!", "not author")
			);
	}

}
