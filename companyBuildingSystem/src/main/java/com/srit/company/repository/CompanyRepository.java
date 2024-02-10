package com.srit.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.srit.company.entity.Companies;

public interface CompanyRepository extends JpaRepository<Companies, Long> {

	@Query("SELECT c FROM Company c WHERE c.numberOfEmployees BETWEEN ?1 AND ?2")
    List<Companies> findByEmployeesRange(int minEmployees, int maxEmployees);

	List<Companies> findCompaniesWithMaxRevenueInIndustry();
}
