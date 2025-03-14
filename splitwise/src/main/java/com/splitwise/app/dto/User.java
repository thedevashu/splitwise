package com.splitwise.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String userEmail;
	private String password;
	
	@ManyToMany(mappedBy = "users")

	private List<Group> groups;
	
	@ManyToMany(mappedBy = "participants")
	@JsonBackReference
	private List<Expense> expenses;
	
	
	

}
