package com.project.ets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ets.entity.Batch;
import com.project.ets.requstdto.BatchRequest;
import com.project.ets.responsedto.BatchResponse;
import com.project.ets.service.BatchService;
import com.project.ets.util.ResponseStructure;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BatchController {
	private BatchService batchService;
	
	@PostMapping("/users/students/batches")
	public ResponseEntity<BatchResponse> saveBatch(@RequestBody BatchRequest request){
		BatchResponse response = batchService.saveBatch(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	

}
