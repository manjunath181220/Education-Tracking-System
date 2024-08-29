package com.project.ets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.ets.enums.UserRole;
import com.project.ets.requstdto.TrainerRequest;
import com.project.ets.responsedto.UserResponse;
import com.project.ets.security.RegistrationRequest;
import com.project.ets.service.UserService;
import com.project.ets.util.AppResponseBuilder;
import com.project.ets.util.ResponseStructure;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@Controller
@AllArgsConstructor
public class TrainerController {
	
	private UserService userService;
	private AppResponseBuilder responseBuilder;
	@PostMapping("/users/trainers/{role}")
	public ResponseEntity<ResponseStructure<UserResponse>> saveTrainer(@RequestBody @Valid RegistrationRequest registrationRequest,@PathVariable UserRole role){
		UserResponse response=userService.saveUser(registrationRequest,role);
		return responseBuilder.success(HttpStatus.CREATED, "Trainer created successfully", response);
	}
	
	@PutMapping("/users/trainers/{userId}")
	public ResponseEntity<ResponseStructure<UserResponse>> updateTrainer(@RequestBody TrainerRequest trainerRequest,@PathVariable String userId){
		UserResponse response=userService.updateTrainer(trainerRequest,userId);
		return responseBuilder.success(HttpStatus.OK, "Trainer updated", response);
	}

}
