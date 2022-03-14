package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.UserEntity;

public interface IUserService {
	List<UserEntity> findAll();
	UserEntity findOne(Long id);
	UserEntity findOneByUserName(String userName);
	Boolean existsByUserName(String userName);
	Boolean existsByEmail(String email);
	UserEntity registerNewUser(String username, String password);
	UserEntity save(UserEntity userEntity);
	void delete(UserEntity userEntity);
}
