package com.laptrinhjavaweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.WardDTO;
import com.laptrinhjavaweb.entity.WardEntity;

@Component
public class WardMapper {

	public WardDTO convertToDTO(WardEntity wardEntity) {
		WardDTO wardDTO = new WardDTO();
		wardDTO.setMaqh(wardEntity.getMaqh());
		wardDTO.setMaxp(wardEntity.getMaxp());
		wardDTO.setName(wardEntity.getName());
		wardDTO.setType(wardEntity.getType());
		return wardDTO;
	}
	
	public WardEntity convertToEntity(WardDTO wardDTO) {
		WardEntity wardEntity = new WardEntity();
				
		return wardEntity;
	}
	
}
