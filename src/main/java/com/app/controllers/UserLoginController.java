package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.User;
import com.app.repositories.UserLoginRepository;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserLoginController {
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody com.app.models.User userData) {
		System.out.println("Ingreso: " + userData.getUsername());
		User user = userLoginRepository.findByUsername(userData.getUsername());
		if(user.getPassword().equals(userData.getPassword())) {
			return ResponseEntity.ok(user);
		}
		else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}
}
