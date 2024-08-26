package com.project.ets.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.project.ets.config.GenerateSequenceId;
import com.project.ets.roles.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
	@Id
	@Column(name = "userId")
	@GenerateSequenceId
	private int userId;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private UserRole role;
	
	@Column(name = "createdDate")
	private LocalDateTime createdDate;
	
	@Column(name = "modifiedDate")
	private LocalDateTime modifiedDate;

}
