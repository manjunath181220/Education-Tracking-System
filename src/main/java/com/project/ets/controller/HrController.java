package com.project.ets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ets.enums.UserRole;
import com.project.ets.responsedto.UserResponse;
import com.project.ets.security.RegistrationRequest;
import com.project.ets.service.UserService;
import com.project.ets.util.AppResponseBuilder;
import com.project.ets.util.ResponseStructure;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class HrController {
	
	private UserService userService;
	private AppResponseBuilder responseBuilder;
	
	@PostMapping("/users/hrs/{role}")
	public ResponseEntity<ResponseStructure<UserResponse>>saveHr(@RequestBody @Valid RegistrationRequest registrationRequest,@PathVariable UserRole role){
		UserResponse hrResponse=userService.saveUser(registrationRequest,role);
		return responseBuilder.success(HttpStatus.CREATED, "Hr created Successfully", hrResponse);
	}

}
