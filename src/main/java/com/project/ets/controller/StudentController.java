package com.project.ets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.project.ets.enums.UserRole;
import com.project.ets.requstdto.StudentRequest;
import com.project.ets.responsedto.StudentResponse;
import com.project.ets.responsedto.UserResponse;
import com.project.ets.security.RegistrationRequest;
import com.project.ets.service.UserService;
import com.project.ets.util.AppResponseBuilder;
import com.project.ets.util.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

public class StudentController {
	
	private UserService userService;
	private AppResponseBuilder responseBuilder;
	
	@PostMapping("/users/students/{role}")
	public ResponseEntity<ResponseStructure<UserResponse>> saveStudent(@RequestBody @Valid RegistrationRequest registrationRequest,@PathVariable UserRole role){
		UserResponse response=userService.saveUser(registrationRequest,role);
		return responseBuilder.success(HttpStatus.CREATED, "Student created successfully", response);
	}
	
	@PutMapping("/users/students/{userId}")
	public ResponseEntity<ResponseStructure<StudentResponse>> updateStudent(@RequestBody StudentRequest studentRequest,@PathVariable String userId){
		StudentResponse studentResponse=userService.updateStudent(studentRequest,userId);
		return responseBuilder.success(HttpStatus.OK, "Student Updated", studentResponse);
	}

}
