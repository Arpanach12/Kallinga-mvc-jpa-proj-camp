package com.mindtree.adminusermvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	private String personName;
	private int personAge;
	private String personPassword;
	private String personRole;

	public Person() {

	}

	public Person(int personId, String personName, int personAge, String personPassword, String personRole) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
		this.personPassword = personPassword;
		this.personRole = personRole;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public String getPersonPassword() {
		return personPassword;
	}

	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}

	public String getPersonRole() {
		return personRole;
	}

	public void setPersonRole(String personRole) {
		this.personRole = personRole;
	}

}
