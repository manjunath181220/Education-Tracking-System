package com.project.ets.config.requestdto;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.project.ets.privilege.UserRole;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class UserRequest 
{
	@NotNull(message = "username can not be a null")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Invalid username, should contain alphabets")
	private String userName;
	
	@NotNull(message = "email can not be a null")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\r\n",message="email should be correct")
	private String email;
	
	@NotNull(message = "password can not be a null")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$\r\n")
	private String password;
	
	@Pattern(regexp = "^[a-zA-Z]{3,15}$\r\n")
	private UserRole role;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	
}
