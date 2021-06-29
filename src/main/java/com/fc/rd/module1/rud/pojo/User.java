package com.fc.rd.module1.rud.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

//	private long id;
	@JsonProperty("name")
	private String name;

	@JsonProperty("password")
	private String password;

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("middleName")
	private String middleName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("telephone")
	private String telephone;

	@JsonProperty("telephoneExtension")
	private String telephoneExtension;

	@JsonProperty("mobile")
	private String mobile;

	@JsonProperty("email")
	private String email;

	public User(String name, String password, String firstName, String middleName, String lastName, String telephone,
			String telephoneExtension, String mobile, String email) {
		super();
//		this.id = id;
		this.name = name;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.telephoneExtension = telephoneExtension;
		this.mobile = mobile;
		this.email = email;
	}

	public User() {
	}

	/*
	 * public long getId() { return id; }
	 * 
	 * public void setId(long id) { this.id = id; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephoneExtension() {
		return telephoneExtension;
	}

	public void setTelephoneExtension(String telephoneExtension) {
		this.telephoneExtension = telephoneExtension;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [ name=" + name + ", password=" + password + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", telephone=" + telephone + ", telephoneExtension="
				+ telephoneExtension + ", mobile=" + mobile + ", email=" + email + "]";
	}

}
