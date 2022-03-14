package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.ProvinceEntity;
import com.laptrinhjavaweb.repository.ProvinceRepository;
import com.laptrinhjavaweb.service.IProvinceService;

@Service
public class ProvinceServiceImpl implements IProvinceService {
	
	@Autowired
	private ProvinceRepository provinceRepository;

	@Override
	public List<ProvinceEntity> findAll() {
		return provinceRepository.findAll();
	}

}
