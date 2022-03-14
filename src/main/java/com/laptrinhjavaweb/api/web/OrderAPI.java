package com.laptrinhjavaweb.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.service.IPurchaseService;

@RestController(value = "orderAPI")
@RequestMapping("/api")
public class OrderAPI {
	
	@Autowired
	private IPurchaseService purchaseService;
	
	@PostMapping(value = {"/order"})
	public ResponseEntity<?> order(@RequestBody OrderDTO order) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseMessage(
						"OK", 
						"Your order has been successfully placed!", 
						purchaseService.order(order)
					)
			);
	}

}
