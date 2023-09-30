package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.User;
import com.app.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUserById(Integer id) {
		return userRepository.findById(id).get();
	};
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	};
	
}
