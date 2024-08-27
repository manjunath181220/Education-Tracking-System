package com.project.ets.config;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.project.ets.model.Super_Admin;
import com.project.ets.model.User;
import com.project.ets.privilege.UserRole;
import com.project.ets.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SuperAdminRegistrationEvent 
{

	private UserRepository userRepo;
	
	@Value("${super_admin.email}")
	private String superAdminEmail;
	
	public SuperAdminRegistrationEvent(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void registerSuperAdmin() 
	{
		log.info("checking if super admin present");
		List<User> users = userRepo.findByRole(UserRole.SUPER_ADMIN);
		boolean result = users.isEmpty();
		if(result)
		{
			log.info("Super admin is not present so creating new one");
			Super_Admin user=new Super_Admin();
			user.setEmail(superAdminEmail);
			user.setPassword(UUID.randomUUID().toString());
			user.setUserName("Admin");
			user.setRole(UserRole.SUPER_ADMIN);
			
			userRepo.save(user);
		}
		else
		{
			log.info("super admin is present with email : "+users.get(0).getEmail());
		}
		
		
	}
	
	
}
