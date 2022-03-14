package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.utils.SecurityUtils;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findOne(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public UserEntity findOneByUserName(String userName) {
		return userRepository.findOneByUserName(userName);
	}

	@Override
	public Boolean existsByUserName(String userName) {
		return userRepository.existsByUserName(userName);
	}

	@Override
	public Boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public UserEntity registerNewUser(String username, String password) {
		UserEntity userEntity = new UserEntity();
		RoleEntity roleEntity = roleRepository.findOneByCode("USER");
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(roleEntity);
		userEntity.setRoles(roles);
		userEntity.setUserName(username);
		userEntity.setPassword(SecurityUtils.encodeMD5(password));
		userEntity.setFullName(username);
		userEntity.setGender(2);
		return userRepository.save(userEntity);
	}

	@Override
	public UserEntity save(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	@Override
	public void delete(UserEntity userEntity) {
		userRepository.delete(userEntity);
	}

}
