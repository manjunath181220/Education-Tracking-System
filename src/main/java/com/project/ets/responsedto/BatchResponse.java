package com.project.ets.responsedto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.project.ets.entity.Student;
import com.project.ets.enums.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatchResponse {
	private String batchId;
	private String title;
	private List<Subject> subjects;
	private LocalDate createdDate;
	private LocalDate closedDate;
	private List<Student> students;

}
