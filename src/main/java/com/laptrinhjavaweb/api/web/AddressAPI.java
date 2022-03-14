package com.laptrinhjavaweb.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.DistrictDTO;
import com.laptrinhjavaweb.dto.ProvinceDTO;
import com.laptrinhjavaweb.dto.WardDTO;
import com.laptrinhjavaweb.dto.response.ResponseMessage;
import com.laptrinhjavaweb.entity.DistrictEntity;
import com.laptrinhjavaweb.entity.ProvinceEntity;
import com.laptrinhjavaweb.entity.WardEntity;
import com.laptrinhjavaweb.mapper.DistrictMapper;
import com.laptrinhjavaweb.mapper.ProvinceMapper;
import com.laptrinhjavaweb.mapper.WardMapper;
import com.laptrinhjavaweb.service.IDistrictService;
import com.laptrinhjavaweb.service.IProvinceService;
import com.laptrinhjavaweb.service.IWardService;

@RestController(value = "addressAPI")
@RequestMapping("/api")
public class AddressAPI {
	
	@Autowired
	private IProvinceService provinceService;
	
	@Autowired
	private IDistrictService districtService;
	
	@Autowired
	private IWardService wardService;
	
	@Autowired
	private ProvinceMapper provinceMapper;

	@Autowired
	private DistrictMapper districtMapper;

	@Autowired
	private WardMapper wardMapper;
	
	@GetMapping(value = {"/list-provinces"})
	public ResponseEntity<?> getListProvinces() {
		List<ProvinceDTO> result = new ArrayList<>();
		for(ProvinceEntity province : provinceService.findAll()) {
			result.add(provinceMapper.convertToDTO(province));
		}
		return ResponseEntity.ok(new ResponseMessage("OK", "Provinces has already taken!", result));
	}
	
	@GetMapping(value = {"/list-districtes"})
	public ResponseEntity<?> getListDistrictes(@RequestParam(required = false, defaultValue = "0", value = "matp") String matp) {
		List<DistrictDTO> result = new ArrayList<>();
		for(DistrictEntity district : districtService.findByMatp(matp)) {
			result.add(districtMapper.convertToDTO(district));
		}
		return ResponseEntity.ok(new ResponseMessage("OK", "Districts has already taken!", result));
	}
	
	@GetMapping(value = {"/list-wards"})
	public ResponseEntity<?> getListWards(@RequestParam(required = false, defaultValue = "0", value = "maqh") String maqh) {
		List<WardDTO> result = new ArrayList<>();
		for(WardEntity ward : wardService.findByMaqh(maqh)) {
			result.add(wardMapper.convertToDTO(ward));
		}
		return ResponseEntity.ok(new ResponseMessage("OK", "Wards has already taken!", result));
	}

}
