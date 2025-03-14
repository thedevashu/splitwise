package com.splitwise.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="group_table")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "groupId")

public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupId;
	private String groupName;
	@ManyToMany
	@JoinTable(
			name="group_user",
			joinColumns = @JoinColumn(name="group_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	@JsonBackReference
	private List<User> users;
	@ElementCollection
	
	private List<Expense> expenses;  

}
