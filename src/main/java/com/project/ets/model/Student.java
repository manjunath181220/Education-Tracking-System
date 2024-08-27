package com.project.ets.model;

import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student extends User
{
	@Column(name="degree")
	private String degree;
	
	@Column(name="stream")
	private String stream;
	
	@Column(name="degreePercent")
	private int degreePercent;
	
	@Column(name="twelthPercent")
	private int twelthPercent;
	
	@Column(name="tentPercent")
	private int tentPercent;
	
	@Column(name="yop")
	private Year yop; 
}
