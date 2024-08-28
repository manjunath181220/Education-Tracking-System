package com.project.ets.requstdto;

import java.time.Year;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest extends UserRequest{
	
	private String degree;
	private String stream;
	private Year yearOfPassout;
	private int degreePercentage;
	private int tenthPercentage;
	private int twelvethPercentage;
	

}
