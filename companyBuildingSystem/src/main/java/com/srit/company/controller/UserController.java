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

import com.srit.company.entity.Clients;
import com.srit.company.entity.Users;
import com.srit.company.exception.ResouceNotFoundException;
import com.srit.company.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public Users createUsers(@RequestBody Users users) {
		return userRepository.save(users);
	}
	
	@GetMapping
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable Long id) {
	Users users= userRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("User not exist.."+ id));
		return ResponseEntity.ok(users) ;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Users> updateClient(@PathVariable Long id, @RequestBody Clients clients) {
	Users users=userRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("Client not exist.."+ id));
		users.setName(users.getName());
		users.setEmail(users.getEmail());
		users.setPhone(users.getPhone());
	
	Users users2=userRepository.save(users);
	return ResponseEntity.ok(users2);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity< Map<String,Boolean>> deleteUser(@PathVariable Long id) {
		Users users=userRepository.findById(id).orElseThrow(()-> new ResouceNotFoundException("client not exist.."+ id));
		
		userRepository.delete(users);
		Map<String,Boolean> responce =new HashMap<>();
		responce.put("User Deleted !!!!", Boolean.TRUE);
		return ResponseEntity.ok(responce);
	}
}
