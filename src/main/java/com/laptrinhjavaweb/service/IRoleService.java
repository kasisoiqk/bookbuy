package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.entity.RoleEntity;

public interface IRoleService {
	RoleEntity findOneByCode(String code);
}
