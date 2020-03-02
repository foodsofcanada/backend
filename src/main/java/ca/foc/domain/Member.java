package ca.foc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="foc_members")
public class Member implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id	
	@Column(unique = true) 
	private String email;
	@Column(name="hashepw")
	private String password;
	private String firstname;
	private String lastname;
	
	//@CreatedDate
	@Temporal(TemporalType.DATE)
	@Column(name="date_joined")
	private Date dateJoined;
	private int role;
	
	@Transient 
	private String confirmPassword;
	
	public Member() {}
	
	public Member(String email, String password, String firstname, String lastname, int role) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}

	
	/*Getters and setters*/
	public String getEmail() {
		return email;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}


	
	

}
