package com.laptrinhjavaweb.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.BillInfoDTO;
import com.laptrinhjavaweb.entity.BillInfoEntity;
import com.laptrinhjavaweb.entity.BookEntity;
import com.laptrinhjavaweb.repository.BookRepository;

@Component
public class BillInfoMapper {
	
	@Autowired
	private BookRepository bookRepository;
	
	public BillInfoDTO convertToDTO(BillInfoEntity billInfoEntity) {
		BookEntity bookEntity = bookRepository.findOne(billInfoEntity.getBookId());
		BillInfoDTO billInfoDTO = new BillInfoDTO();
		billInfoDTO.setId(billInfoEntity.getId());
		billInfoDTO.setBookName(bookEntity.getName());
		billInfoDTO.setCurrentPrice(billInfoEntity.getPrice());
		billInfoDTO.setOldPrice(bookEntity.getOldPrice());
		billInfoDTO.setImage(bookEntity.getImage());
		billInfoDTO.setAuthor(bookEntity.getAuthor());
		billInfoDTO.setStatus(billInfoEntity.getBill().getStatus());
		billInfoDTO.setQuantity(billInfoEntity.getQuantity());
		return billInfoDTO;
	}
	
	public BillInfoEntity convertToEntity(BillInfoDTO billInfoDTO) {
		BillInfoEntity billInfoEntity = new BillInfoEntity();
		
		return billInfoEntity;
	}

}
