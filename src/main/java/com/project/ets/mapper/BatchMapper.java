package com.project.ets.mapper;

import org.springframework.stereotype.Component;

import com.project.ets.entity.Batch;
import com.project.ets.requstdto.BatchRequest;
import com.project.ets.responsedto.BatchResponse;
@Component
public class BatchMapper {
	
	public Batch mapToBatchEntity(BatchRequest request,Batch batch) {
		batch.setTitle(request.getTitle());
		batch.setSubjects(batch.getSubjects());
		batch.setStudents(request.getStudents());
		return batch;
	}
	
	public BatchResponse mapToBatchResponse(Batch batch) {
		BatchResponse response=new BatchResponse();
		response.setBatchId(batch.getBatchId());
		response.setTitle(batch.getTitle());
		response.setSubjects(batch.getSubjects());
		response.setCreatedDate(batch.getCreatedDate());
		response.setClosedDate(batch.getClosedDate());
		response.setStudents(batch.getStudents());
		
		return response;
	}

}
