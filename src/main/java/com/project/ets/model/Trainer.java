package com.project.ets.model;

import java.util.List;

import com.project.ets.privilege.Subject;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="trainers")
public class Trainer extends User{

	private List<Subject> subjects;
}
