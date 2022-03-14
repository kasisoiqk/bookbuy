package com.laptrinhjavaweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.DistrictDTO;
import com.laptrinhjavaweb.entity.DistrictEntity;

@Component
public class DistrictMapper {

	public DistrictDTO convertToDTO(DistrictEntity districtEntity) {
		DistrictDTO districtDTO = new DistrictDTO();
		districtDTO.setMaqh(districtEntity.getMaqh());
		districtDTO.setMatp(districtEntity.getMatp());
		districtDTO.setName(districtEntity.getName());
		districtDTO.setType(districtEntity.getType());
		return districtDTO;
	}
	
	public DistrictEntity convertToEntity(DistrictDTO districtDTO) {
		DistrictEntity districtEntity = new DistrictEntity();
		
		return districtEntity;
	}
	
}
