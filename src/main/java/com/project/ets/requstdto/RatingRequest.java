package com.project.ets.requstdto;

import com.project.ets.enums.Subject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingRequest {
	private Subject subject;
	private int rating;
	private String feedback;

}
