package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.WardEntity;

@Repository
public interface WardRepository extends JpaRepository<WardEntity, Long> {
	List<WardEntity> findByMaqh(String maqh);
}
