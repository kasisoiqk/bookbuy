package com.laptrinhjavaweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BillDTO;
import com.laptrinhjavaweb.entity.BillEntity;

@Component
public class BillMapper {

	public BillDTO convertToDTO(BillEntity billEntity) {
		BillDTO billDTO = new BillDTO();
		billDTO.setId(billEntity.getId());
		billDTO.setCustomerId(billEntity.getCustomerId());
		billDTO.setStatus(billEntity.getStatus());
		billDTO.setTotalPrice(billDTO.getTotalPrice());
		return billDTO;
	}
	
	public BillEntity convertToEntity(BillDTO billDTO) {
		BillEntity billEntity = new BillEntity();
		
		return billEntity;
	}
	
}
