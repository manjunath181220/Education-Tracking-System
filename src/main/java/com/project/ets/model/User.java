package com.project.ets.model;

import java.time.LocalDateTime;

import com.project.ets.config.GenerateSquenceId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Data
//@AllArgsConstructor
public class User {

	@Id
	@GenerateSquenceId
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	@Column(name="email")
	private String email;
	
	@Column(name="created_date")
	private LocalDateTime createdDate;
	
	@Column(name="modified_date")
	private LocalDateTime ModifiedDate;
	
}
