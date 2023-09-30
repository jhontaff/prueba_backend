package com.app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Integer id;
	private String username;
	private String password;
	private String full_name;
	private int identification;
	private int phone;
	private String role;
	
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return this.username;
	}
	public String getPassword() {
		int passwordLength = this.password.length();
		StringBuilder maskedPassword = new StringBuilder(passwordLength);
		for (int i = 0; i < passwordLength; i++) {
			maskedPassword.append("*");
		}
		return maskedPassword.toString();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public User() {
		super();
	}
	public User(Integer id, String username, String password, String full_name, int identification, int phone, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.full_name = full_name;
		this.identification = identification;
		this.phone = phone;
		this.role = role;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public int getIdentification() {
		return identification;
	}
	public void setIdentification(int identification) {
		this.identification = identification;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
