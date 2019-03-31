package com.application.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
//ctrl+shift+O - shortcut for dependencies import

//@SuppressWarnings({ "unused", "deprecation" })
@Entity
@Table(name="Student")
@EntityListeners(AuditingEntityListener.class)


public class Student {

	public Student() {
		
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Size(min=3,max=30)
	@NotEmpty(message="First Name should not be Empty")
	private String firstName;
	@NotEmpty(message="Last Name should not be Empty")
	@Size(min=3,max=30)
	private String lastName;
	
	//@SuppressWarnings("deprecation")
	@NotBlank(message="It should not be blank")
	@Email(message="Please Enter Proper Email Id")
	private String email;
	
	//@SuppressWarnings("deprecation")
	@NotBlank
	private String country;
	
	//@SuppressWarnings("deprecation")
	@NotEmpty
	private String sex;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date createdAt;
	
	//@SuppressWarnings("deprecation")
	@NotEmpty
	private String section;
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	
}
