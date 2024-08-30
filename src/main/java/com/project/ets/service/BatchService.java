package com.project.ets.service;

import org.springframework.stereotype.Service;

import com.project.ets.entity.Batch;
import com.project.ets.mapper.BatchMapper;
import com.project.ets.repository.BatchRepository;
import com.project.ets.requstdto.BatchRequest;
import com.project.ets.responsedto.BatchResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BatchService {
	private BatchRepository batchRepository;
	private BatchMapper mapper;
	
	public BatchResponse saveBatch(BatchRequest request) {
		Batch batch = batchRepository.save(mapper.mapToBatchEntity(request, new Batch()));
		return mapper.mapToBatchResponse(batch);
	}
	
	

}
