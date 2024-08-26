package com.project.ets.privilege;

import java.util.List;

public enum UserRole {

	SUPER_ADMIN(List.of(Privilege.WRITE_ADMIN,
						Privilege.WRITE_HR,
						Privilege.READ_BATCH,
						Privilege.READ_USER,
						Privilege.READ_MOCK,
						Privilege.READ_RATINGS,
						Privilege.READ_REQUIREMENT,
						Privilege.READ_SCHEDULE,
						Privilege.READ_TECH_REPORT
						)),
	ADMIN(List.of(Privilege.WRITE_ADMIN,
						Privilege.WRITE_HR,
						Privilege.READ_BATCH,
						Privilege.READ_USER,
						Privilege.READ_MOCK,
						Privilege.READ_RATINGS,
						Privilege.READ_REQUIREMENT,
						Privilege.READ_SCHEDULE,
						Privilege.READ_TECH_REPORT
						)),
	HR(List.of(Privilege.READ_REQUIREMENT,
				Privilege.WRITE_REQUIREMENT,
				Privilege.READ_MOCK,
				Privilege.WRITE_MOCK,
				Privilege.READ_RATINGS,
				Privilege.WRITE_RATINGS,
				Privilege.READ_SCHEDULE,
				Privilege.WRITE_SCHEDULE,
				Privilege.READ_TECH_REPORT,
				Privilege.WRITE_TECH_REPORT)),
	TRAINER(List.of(
				Privilege.READ_MOCK,
				Privilege.WRITE_MOCK,
				Privilege.READ_RATINGS,
				Privilege.READ_BATCH,
				Privilege.READ_USER,
				Privilege.WRITE_TECH_REPORT,
				Privilege.READ_TECH_REPORT)),
	STUDENT(List.of(
			Privilege.READ_MOCK,
			Privilege.WRITE_MOCK,
			Privilege.READ_SCHEDULE,
			Privilege.READ_REQUIREMENT,
			Privilege.READ_USER,
			Privilege.READ_TECH_REPORT,
			Privilege.WRITE_STUDENT));

	private List<Privilege> privileges;
	
	private UserRole(List<Privilege> privilege)
	{
		this.privileges=privilege;
	}
	
	public List<Privilege> getPrivilege()
	{
		return privileges;
	}
	
	
}
