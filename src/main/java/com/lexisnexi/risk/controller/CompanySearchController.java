package com.lexisnexi.risk.controller;

import com.lexisnexi.risk.CompanyDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/TruProxyAPI/rest/Companies/v1")
public class CompanySearchController {

	@GetMapping("/Search")
	public ResponseEntity<CompanyDetails> getCompany() {
		return new ResponseEntity<>(getCompanyDetails(), HttpStatus.OK);
	}
	private CompanyDetails getCompanyDetails() {
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setCompanyName("Sarsun");
		companyDetails.setCompanyNumber("1234");
		return companyDetails;
	}
}
