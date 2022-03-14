package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.DistrictEntity;

public interface IDistrictService {
	List<DistrictEntity> findByMatp(String matp);
}
