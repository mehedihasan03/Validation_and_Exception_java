package com.example.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
@Data
@Validated
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false)
	@NotNull(message = "User ID shouldn't be Empty")
	private String userId;

	@Column(nullable = false)
	@NotNull(message = "Password shouldn't be Empty")
	private String password;

	@Pattern(regexp = "^\\d{11}$", message = "Invalid Mobile Number")
	@NotNull(message = "Mobile Number shouldn't be Empty")
	@NotBlank
	@Column(nullable = false)
	private String mobile;

	public User() {
		super();
	}

	public User(long id, String userId, String password, String mobile) {
		super();
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.mobile = mobile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
