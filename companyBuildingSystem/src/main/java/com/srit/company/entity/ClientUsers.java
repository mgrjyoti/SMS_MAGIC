package com.srit.company.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ClientUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
    private boolean active;
    @ManyToOne
    private Clients clients;
    @ManyToOne
    private Users user;

	
}

