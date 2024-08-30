package com.project.ets.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.project.ets.config.GenerateSequenceId;
import com.project.ets.enums.Subject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Batches")
public class Batch  {
	@Id
	@GenerateSequenceId
	@Column(name = "batchId")
	private String batchId;
	@Column(name = "title")
	private String title;
	@Column(name = "subjects")
	private List<Subject> subjects;
	@Column(name = "createdDate")
	@CreatedDate
	private LocalDate createdDate;
	@Column(name = "closedDate")
	private LocalDate closedDate;
	@ManyToMany
	@Column(name = "students")
	private List<Student> students;

}
