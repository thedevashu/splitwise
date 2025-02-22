package com.splitwise.app.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
public class User implements UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String userName;
	private String userEmail;
	private String password;  // ✅ Added password field

	@ManyToMany(mappedBy = "users")
	@JsonBackReference
	private List<Group> groups;

	@ManyToMany(mappedBy = "participants")
	private List<Expense> expenses;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// ✅ If you have roles, return them here. Otherwise, return an empty list.
		return List.of(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		this.password = passwordEncoder.encode(password);
	}

	@Override
	public String getUsername() {
		return userEmail; // ✅ Using email as username
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // ✅ Account never expires
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // ✅ Account never gets locked
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // ✅ Credentials never expire
	}

	@Override
	public boolean isEnabled() {
		return true; // ✅ User is always enabled
	}
}
