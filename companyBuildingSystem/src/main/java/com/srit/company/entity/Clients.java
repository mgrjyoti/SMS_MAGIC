package com.srit.company.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Clients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private long phone;
	
	@OneToOne
	private Users users;
	@OneToOne
	private Companies companies;
	public void setUsers(List<Clients> allEmployees) {
		
	}
}



