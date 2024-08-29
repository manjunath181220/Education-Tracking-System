package com.project.ets.service;

import org.springframework.stereotype.Service;

import com.project.ets.mapper.BatchMapper;
import com.project.ets.repository.BatchRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BatchService {
	private BatchRepository batchRepository;
	private BatchMapper mapper;
	
	

}
