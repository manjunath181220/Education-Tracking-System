package com.project.ets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ets.enums.UserRole;
import com.project.ets.responsedto.UserResponse;
import com.project.ets.security.RegistrationRequest;
import com.project.ets.service.UserService;
import com.project.ets.util.AppResponseBuilder;
import com.project.ets.util.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AdminController {
	private UserService adminService;
	private AppResponseBuilder responseBuilder;
	
	@PostMapping("/users/admins/{role}")
	public ResponseEntity<ResponseStructure<UserResponse>> saveAdmin(@RequestBody @Valid  RegistrationRequest registrationRequest,@PathVariable UserRole role) {
		UserResponse adminResponse=adminService.saveUser(registrationRequest,role);
		return responseBuilder.success(HttpStatus.CREATED,"Admin created Successfully", adminResponse);
	}

}
