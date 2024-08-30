package com.project.ets.requstdto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.project.ets.entity.Student;
import com.project.ets.enums.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatchRequest {
	
	private String title;
	private LocalTime beginsAt;
	private LocalTime endsAt;
	private LocalDate startingDate;
	private List<Subject> subjects;
	
	

}
