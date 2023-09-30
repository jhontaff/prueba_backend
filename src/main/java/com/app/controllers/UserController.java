package com.app.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.models.User;
import com.app.services.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/allusers")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> saveNewUser(@RequestBody User user){
		User new_user = userService.saveUser(user);
		return new ResponseEntity<>(new_user, HttpStatus.CREATED);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getOneUser(@PathVariable Integer id){
		User userById = userService.getUserById(id);
		return ResponseEntity.ok(userById);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User user){
		User userById = userService.getUserById(id);
		userById.setFull_name(user.getFull_name());
		userById.setIdentification(user.getIdentification());
		userById.setPassword(user.getPassword());
		userById.setPhone(user.getPhone());
		userById.setUsername(user.getUsername());
		
		User updated_user = userService.saveUser(userById);
		return new ResponseEntity<>(updated_user, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<HashMap<String, Boolean>> deleteOneUser(@PathVariable Integer id) {
		this.userService.deleteUser(id);
		HashMap<String, Boolean> deletedUser = new HashMap<>();
		deletedUser.put("Eliminado", true);
		return ResponseEntity.ok(deletedUser);
	}
}
