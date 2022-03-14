package com.laptrinhjavaweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.ProvinceDTO;
import com.laptrinhjavaweb.entity.ProvinceEntity;

@Component
public class ProvinceMapper {

	public ProvinceDTO convertToDTO(ProvinceEntity provinceEntity) {
		ProvinceDTO provinceDTO = new ProvinceDTO();
		provinceDTO.setMatp(provinceEntity.getMatp());
		provinceDTO.setName(provinceEntity.getName());
		provinceDTO.setType(provinceEntity.getType());
		return provinceDTO;
	}
	
	public ProvinceEntity convertToEntity(ProvinceDTO provinceDTO) {
		ProvinceEntity provinceEntity = new ProvinceEntity();
		
		return provinceEntity;
	}
	
}
