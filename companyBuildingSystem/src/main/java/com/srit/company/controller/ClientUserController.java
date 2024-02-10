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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srit.company.entity.ClientUsers;
import com.srit.company.entity.Clients;
import com.srit.company.exception.ResouceNotFoundException;
import com.srit.company.repository.ClientUserRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/clientUser")
public class ClientUserController {

	@Autowired
	private ClientUserRepository clientUserRepository;
	
	@PostMapping
	public ClientUsers createClientUsers(@RequestBody ClientUsers clientUsers) {
		return clientUserRepository.save(clientUsers);
	}
	
	@GetMapping
	public List<ClientUsers> getAllClientsUsers() {
		return clientUserRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientUsers> getClientsUserById(@PathVariable Long id) {
	ClientUsers clientUsers= clientUserRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("User not exist.."+ id));
		return ResponseEntity.ok(clientUsers) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientUsers> updateClient(@PathVariable Long id, @RequestBody Clients clients) {
	ClientUsers clients2= clientUserRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Client not exist.."+ id));
	
	clients2.setCreatedAt(clients2.getCreatedAt());
	clients2.setUpdatedAt(clients2.getUpdatedAt());
	clients2.setDeletedAt(clients2.getDeletedAt());
	clients2.setClients(clients2.getClients());
	clients2.setUser(clients2.getUser());
	clients2.setActive(true);
	
	ClientUsers clients3=clientUserRepository.save(clients2);
	return ResponseEntity.ok(clients3);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity< Map<String,Boolean>> deleteClientsUser(@PathVariable Long id) {
		ClientUsers clients= clientUserRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("client not exist.."+ id));
		
		clientUserRepository.delete(clients);
		Map<String,Boolean> responce =new HashMap<>();
		responce.put("Client Deleted !!!!", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
}

