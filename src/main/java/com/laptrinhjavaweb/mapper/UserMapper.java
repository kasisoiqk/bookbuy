package com.laptrinhjavaweb.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.RoleRepository;

@Component
public class UserMapper {
	
	@Autowired
	private RoleRepository roleRepository;

	@SuppressWarnings("deprecation")
	public UserDTO convertToDTO(UserEntity userEntity) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userEntity.getId());
		userDTO.setUsername(userEntity.getUserName());
		userDTO.setFullName(userEntity.getFullName());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setPhone(userEntity.getPhone());
		userDTO.setGender(userEntity.getGender());
		try {
			
			userDTO.setBirthday(userEntity.getBirthday().getDate());
			userDTO.setBirthmonth(userEntity.getBirthday().getMonth()+1);
			userDTO.setBirthyear(userEntity.getBirthday().getYear()+1900);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String role = userEntity.getRoles().get(0).getCode();
			userDTO.setRole(role);
		} catch (Exception e) {
			userDTO.setRole("USER");
		}
		return userDTO;
	}
	
	public UserDTO convertToDTOContainsPassword(UserEntity userEntity) {
		UserDTO userDTO = convertToDTO(userEntity);
		userDTO.setPassword(userEntity.getPassword());
		return userDTO;
	}
	
	@SuppressWarnings("deprecation")
	public UserEntity convertToEntity(UserDTO userDTO) {
		UserEntity userEntity = new UserEntity();
		userEntity.setId(userDTO.getId());
		Timestamp time = new Timestamp(System.currentTimeMillis());
		time.setDate(userDTO.getBirthday());
		time.setMonth(userDTO.getBirthmonth()-1);
		time.setYear(userDTO.getBirthyear()-1900);
		userEntity.setBirthday(time);
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setPhone(userDTO.getPhone());
		userEntity.setFullName(userDTO.getFullName());
		userEntity.setGender(userDTO.getGender());
		userEntity.setUserName(userDTO.getUsername());
		userEntity.setPassword(userDTO.getPassword());
		RoleEntity roleEntity = roleRepository.findOneByCode(userDTO.getRole());
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(roleEntity);
		userEntity.setRoles(roles);
		return userEntity;
	}
	
}
