package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.WardEntity;

public interface IWardService {
	List<WardEntity> findByMaqh(String maqh);
}
