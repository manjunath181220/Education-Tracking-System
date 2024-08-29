package com.project.ets.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.ets.entity.Admin;
import com.project.ets.entity.HR;
import com.project.ets.entity.Rating;
import com.project.ets.entity.Student;
import com.project.ets.entity.Trainer;
import com.project.ets.entity.User;
import com.project.ets.enums.Stack;
import com.project.ets.enums.Subject;
import com.project.ets.enums.UserRole;
import com.project.ets.exception.UserNotFoundByIdException;
import com.project.ets.mapper.UserMapper;
import com.project.ets.repository.RatingRepository;
import com.project.ets.repository.UserRepository;
import com.project.ets.requstdto.StudentRequest;
import com.project.ets.requstdto.TrainerRequest;
import com.project.ets.requstdto.UserRequest;
import com.project.ets.responsedto.StudentResponse;
import com.project.ets.responsedto.UserResponse;
import com.project.ets.security.RegistrationRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	private UserRepository userRepository;
	private UserMapper mapper;
	private RatingRepository ratingRepository;

	
//	public UserResponse saveAdmin(RegistrationRequest registrationRequest) {
//		User user = mapper.mapToUserEntity(registrationRequest, new Admin());
//		user =userRepository.save(user);
//		return mapper.mapToUserResponse(user);
//	}
//	public UserResponse saveHr(RegistrationRequest registrationRequest ) {
//		User user=mapper.mapToUserEntity(registrationRequest, new HR());
//		return mapper.mapToUserResponse(user);
//	}
//	public UserResponse saveTrainer(RegistrationRequest registrationRequest) {
//		User user=mapper.mapToUserEntity(registrationRequest, new Trainer());
//		return mapper.mapToUserResponse(user);
//	}
//	public UserResponse saveStudent(RegistrationRequest registrationRequest) {
//		User user=mapper.mapToUserEntity(registrationRequest, new Student());
//		return mapper.mapToUserResponse(user);
//	}
	public UserResponse saveUser(RegistrationRequest registrationRequest,UserRole role) {
	User user = null;
	switch (role) {
	case ADMIN -> user = new Admin();
	case HR -> user = new HR();
	case STUDENT -> user = new Student();
	case TRAINER -> user = new Trainer();
	default -> throw new IllegalArgumentException("Unexpected value: " + role);
	}
	
	if(user != null) {
		user = mapper.mapToUserEntity(registrationRequest, user);
		user.setRole(role);
		user = userRepository.save(user);
	}
	
	return mapper.mapToUserResponse(user);
	}
	
	public UserResponse updateTrainer(TrainerRequest trainerRequest,String userId) {		
		return userRepository.findById(userId).map((user)->{
			user=mapper.mapToTrainerEntity(trainerRequest,(Trainer) user);
			user=userRepository.save(user);
			return mapper.mapToUserResponse(user);
		}).orElseThrow(()->new UserNotFoundByIdException("failed to update the trainer"));
	}
	
	public StudentResponse updateStudent(StudentRequest studentRequest, String userId) {
		return userRepository.findById(userId).map((user)->{
			user=mapper.mapToStudentEntity(studentRequest,(Student) user);
			user=userRepository.save(user);
			return mapper.mapToStudentResponse((Student)user);
		}).orElseThrow(()->new UserNotFoundByIdException("failed to update the student"));
	}

	public StudentResponse updateStudent(Stack stack, String userId) {
		
			return	userRepository.findById(userId).map(user->{
			Student student=(Student)user;
			stack.getSubjects().forEach(subject->{
				Rating rating = new Rating();
				rating.setSubject(subject);
				ratingRepository.save(rating);
			});
			student.setStack(stack);
			user=userRepository.save(student);
			return mapper.mapToStudentResponse(student);
		}).orElseThrow(()->new UserNotFoundByIdException("faied to update stack to the student"));
	}


}
