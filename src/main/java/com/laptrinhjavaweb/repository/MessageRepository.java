package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.MessageEntity;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

	@Query("select m from MessageEntity m where (m.senderId = ?1 and m.recipientId = ?2) or (m.senderId = ?2 and m.recipientId = ?1)")
	List<MessageEntity> getMessage(Long senderId, Long recipientId);
	
}
