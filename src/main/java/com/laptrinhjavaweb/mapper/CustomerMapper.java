package com.laptrinhjavaweb.mapper;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CustometDTO;
import com.laptrinhjavaweb.entity.CustomerEntity;

@Component
public class CustomerMapper {

	public CustometDTO convertToDTO(CustomerEntity customerEntity) {
		CustometDTO custometDTO = new CustometDTO();
		custometDTO.setId(customerEntity.getId());
		custometDTO.setFullName(customerEntity.getFullName());
		custometDTO.setInfoExtra(customerEntity.getInfoExtra());
		custometDTO.setPhone(customerEntity.getPhone());
		custometDTO.setNumber(customerEntity.getNumber());
		custometDTO.setProvince(customerEntity.getProvince());
		custometDTO.setDistrict(customerEntity.getDistrict());
		custometDTO.setWard(customerEntity.getWard());
		return custometDTO;
	}
	
	public CustomerEntity convertToEntity(CustometDTO custometDTO) {
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setId(custometDTO.getId());
		customerEntity.setFullName(custometDTO.getFullName());
		customerEntity.setInfoExtra(custometDTO.getInfoExtra());
		customerEntity.setPhone(custometDTO.getPhone());
		customerEntity.setNumber(custometDTO.getNumber());
		customerEntity.setWard(custometDTO.getWard());
		customerEntity.setDistrict(custometDTO.getDistrict());
		customerEntity.setProvince(custometDTO.getProvince());
		return customerEntity;
	}
	
}
