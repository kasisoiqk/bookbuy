package com.laptrinhjavaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.WardEntity;
import com.laptrinhjavaweb.repository.WardRepository;
import com.laptrinhjavaweb.service.IWardService;

@Service
public class WardServiceImpl implements IWardService {
	
	@Autowired
	private WardRepository wardRepository;

	@Override
	public List<WardEntity> findByMaqh(String maqh) {
		return wardRepository.findByMaqh(maqh);
	}

}
