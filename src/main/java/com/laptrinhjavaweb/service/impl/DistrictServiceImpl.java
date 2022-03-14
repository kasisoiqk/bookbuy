package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.service.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService {
	
	@Autowired
	private DistrictRepository districtRepository;

	@Override
	public List<DistrictEntity> findByMatp(String matp) {
		return districtRepository.findByMatp(matp);
	}

}
