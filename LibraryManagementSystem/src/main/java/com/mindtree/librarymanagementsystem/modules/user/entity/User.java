package com.mindtree.librarymanagementsystem.modules.user.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mindtree.librarymanagementsystem.modules.common.enums.UserStatus;
import com.mindtree.librarymanagementsystem.modules.feedback.entity.Feedback;
import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private Long userId;
	@Column(name="USERNAME")
	private String username;
	private String fullName;
	private Byte age;
	private Long phoneNumber;
	private String emailId;
	private String password;
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;
	private LocalDate dateOfJoining;
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }, fetch=FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<Feedback> feedbacks = new HashSet<>();
	@OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	private Set<IssueRecord> issueRecords = new HashSet<>();

	/**
	 * 
	 */
	public User() {
		super();
	}

	
	/**
	 * @param userId
	 * @param username
	 * @param fullName
	 * @param age
	 * @param phoneNumber
	 * @param emailId
	 * @param password
	 * @param userStatus
	 * @param dateOfJoining
	 * @param roles
	 * @param feedbacks
	 * @param issueRecords
	 */
	public User(Long userId, String username, String fullName, Byte age, Long phoneNumber, String emailId,
			String password, UserStatus userStatus, LocalDate dateOfJoining, Set<Role> roles, Set<Feedback> feedbacks,
			Set<IssueRecord> issueRecords) {
		super();
		this.userId = userId;
		this.username = username;
		this.fullName = fullName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		this.userStatus = userStatus;
		this.dateOfJoining = dateOfJoining;
		this.roles = roles;
		this.feedbacks = feedbacks;
		this.issueRecords = issueRecords;
	}


	


	public User(String string, byte b, long l, String string2, String string3, UserStatus active, LocalDate parse,
			Object object, Object object2, Object object3) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.fullName = fullName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		this.userStatus = userStatus;
		this.dateOfJoining = dateOfJoining;
		this.roles = roles;
		this.feedbacks = feedbacks;
		this.issueRecords = issueRecords;
	}


	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return username;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.username = userName;
	}

	/**
	 * @return the age
	 */
	public Byte getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Byte age) {
		this.age = age;
	}

	/**
	 * @return the phoneNumber
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userStatus
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(UserStatus userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the dateOfJoining
	 */
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	/**
	 * @param dateOfJoining the dateOfJoining to set
	 */
	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	/**
	 * @return the role
	 */
	public Set<Role> getRole() {
		return roles;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Set<Role> role) {
		this.roles = role;
	}

	/**
	 * @return the feedbacks
	 */
	public Set<Feedback> getFeedbacks() {
		return feedbacks;
	}

	/**
	 * @param feedbacks the feedbacks to set
	 */
	public void setFeedbacks(Set<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	/**
	 * @return the issueRecords
	 */
	public Set<IssueRecord> getIssueRecords() {
		return issueRecords;
	}

	/**
	 * @param issueRecords the issueRecords to set
	 */
	public void setIssueRecords(Set<IssueRecord> issueRecords) {
		this.issueRecords = issueRecords;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
