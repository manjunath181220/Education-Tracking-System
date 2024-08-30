package com.project.ets.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.ets.enums.Stack;
import com.project.ets.enums.UserRole;
import com.project.ets.requstdto.StudentRequest;
import com.project.ets.responsedto.RatingResponse;
import com.project.ets.responsedto.StudentResponse;
import com.project.ets.responsedto.UserResponse;
import com.project.ets.security.RegistrationRequest;
import com.project.ets.service.UserService;
import com.project.ets.util.AppResponseBuilder;
import com.project.ets.util.ResponseStructure;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
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
	@PatchMapping("/users/students/{userId}")
	public ResponseEntity<ResponseStructure<StudentResponse>> updateStudentStack(@RequestParam Stack stack,@PathVariable String userId){
		StudentResponse response=userService.updateStudent(stack, userId);
		return responseBuilder.success(HttpStatus.OK, "Student stack is Updated", response);
	}
	
	@GetMapping("users/students/ratings/{userId}")
	public ResponseEntity<ResponseStructure<List<RatingResponse>>> viewRating(@PathVariable String userId){
		List<RatingResponse> responses=userService.viewRating(userId);
		return responseBuilder.success(HttpStatus.FOUND, "found the ratings of the student", responses);
	}

}
