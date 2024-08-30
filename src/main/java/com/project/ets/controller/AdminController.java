package com.project.ets.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ets.enums.UserRole;
import com.project.ets.requstdto.BatchRequest;
import com.project.ets.responsedto.BatchResponse;
import com.project.ets.responsedto.UserResponse;
import com.project.ets.security.RegistrationRequest;
import com.project.ets.service.BatchService;
import com.project.ets.service.UserService;
import com.project.ets.util.AppResponseBuilder;
import com.project.ets.util.ResponseStructure;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AdminController {
	private UserService adminService;
	private AppResponseBuilder responseBuilder;
	private BatchService batchService;
	
	@PostMapping("/users/admins/{role}")
	public ResponseEntity<ResponseStructure<UserResponse>> saveAdmin(@RequestBody @Valid RegistrationRequest registrationRequest,@PathVariable UserRole role) {
		UserResponse adminResponse=adminService.saveUser(registrationRequest,role);
		return responseBuilder.success(HttpStatus.CREATED,"Admin created Successfully", adminResponse);
	}
	
	@PostMapping("/admins/batches")
	public ResponseEntity<BatchResponse> saveBatch(@RequestBody BatchRequest request){
		BatchResponse response = batchService.saveBatch(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	@PutMapping("/admins/batches/{batchId}")
	public ResponseEntity<BatchResponse> updateBatch(@RequestBody BatchRequest request,@PathVariable String batchId){
		BatchResponse response=batchService.updateBatch(request,batchId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
