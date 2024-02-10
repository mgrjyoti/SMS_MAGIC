package com.srit.company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srit.company.entity.Companies;
import com.srit.company.exception.ResouceNotFoundException;
import com.srit.company.repository.CompanyRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyRepository companyRepository;
	
	@PostMapping
	public Companies createCompany(@RequestBody Companies companies) {
		return companyRepository.save(companies);
	}
	
	@GetMapping
	public List<Companies> getAllCompany() {
		return companyRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Companies> getUserById(@PathVariable Long id) {
	Companies companies= companyRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("User not exist.."+ id));
		return ResponseEntity.ok(companies) ;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity< Map<String,Boolean>> deleteCompany(@PathVariable Long id) {
		Companies companies= companyRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("client not exist.."+ id));
		
		companyRepository.delete(companies);
		Map<String,Boolean> responce =new HashMap<>();
		responce.put("Company Deleted !!!!", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
	
	@GetMapping("/searchByEmployeesRange")
    public List<Companies> searchByEmployeesRange(@RequestParam int minEmployees, @RequestParam int maxEmployees) {
        return companyRepository.findByEmployeesRange(minEmployees, maxEmployees);
    }

    
    @GetMapping("/searchCompaniesWithMaxRevenue")
    public List<Companies> searchCompaniesWithMaxRevenueInIndustry() {
        return companyRepository.findCompaniesWithMaxRevenueInIndustry();
    }
}
