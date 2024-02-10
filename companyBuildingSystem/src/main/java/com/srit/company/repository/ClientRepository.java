package com.srit.company.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srit.company.entity.Clients;
import com.srit.company.entity.Users;

public interface ClientRepository extends JpaRepository<Clients, Long>{

	List<Clients> findByUser(Users user);
    List<Clients> findByCompanyNameContaining(String companyName);
}
