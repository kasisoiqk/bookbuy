package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleEntity findOneByCode(String code) {
		return roleRepository.findOneByCode(code);
	}

}
