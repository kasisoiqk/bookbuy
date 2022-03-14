package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.BillEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {

}
