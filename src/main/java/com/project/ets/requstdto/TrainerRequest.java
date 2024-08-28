package com.project.ets.requstdto;

import java.util.List;

import com.project.ets.enums.Subject;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TrainerRequest extends UserRequest{
	
	private List<Subject> subjects;

}
