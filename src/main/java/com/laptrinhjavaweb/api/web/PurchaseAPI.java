package com.laptrinhjavaweb.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.service.IPurchaseService;

@RestController(value = "purchaseAPI")
@RequestMapping("/api")
public class PurchaseAPI {
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@GetMapping(value = {"/list-purchases"})
	public ResponseEntity<?> getListPurchases(@RequestParam(required = false, defaultValue = "0", value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage(
						"OK", 
						"List purchases has already taken!", 
						purchaseService.getListPurchase(id)
					)
			);
	}
	
	@GetMapping(value = {"/cancel-purchase"})
	public ResponseEntity<?> cancelPurchase(@RequestParam(required = false, defaultValue = "0", value = "id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage(
						"OK", 
						"", 
						purchaseService.cancelPurchase(id)
					)
			);
	}

}
