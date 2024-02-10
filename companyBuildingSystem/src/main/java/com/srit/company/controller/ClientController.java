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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srit.company.entity.Clients;
import com.srit.company.exception.ResouceNotFoundException;
import com.srit.company.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;
	
	@PostMapping
	public Clients createClient(@RequestBody Clients clients) {
		return clientRepository.save(clients);
	}
	
	@GetMapping
	public List<Clients> getAllEmployees() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Clients> getClientById(@PathVariable Long id) {
		Clients clients= clientRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Client not exist.."+ id));
		return ResponseEntity.ok(clients) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Clients> updateClient(@PathVariable Long id, @RequestBody Clients clients) {
	Clients clients2= clientRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Client not exist.."+ id));
		
	clients2.setName(clients2.getName());
	clients2.setEmail(clients2.getEmail());
	clients2.setPhone(clients2.getPhone());
	clients2.setUsers(getAllEmployees());
	clients2.setCompanies(clients2.getCompanies());
		
	Clients clients3=clientRepository.save(clients2);
	return ResponseEntity.ok(clients3);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity< Map<String,Boolean>> deleteEmployee(@PathVariable Long id) {
		Clients clients= clientRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("client not exist.."+ id));
		
		clientRepository.delete(clients);
		Map<String,Boolean> responce =new HashMap<>();
		responce.put("Client Deleted !!!!", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
	
    @GetMapping("/findByCompanyNameContaining")
    public List<Clients> findByCompanyNameContaining(@RequestParam String companyName) {
        return clientRepository.findByCompanyNameContaining(companyName);
    }

	
}
