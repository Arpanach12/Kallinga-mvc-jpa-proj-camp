package com.mindtree.librarymanagementsystem.modules.user.dto;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.librarymanagementsystem.modules.common.enums.UserStatus;
import com.mindtree.librarymanagementsystem.modules.feedback.dto.FeedbackDto;
import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;

public class UserDto {

	private Long userId;
	private String mindId;
	@NotNull
	@Pattern(regexp="^[a-zA-Z_-]$")
	private String userName;
	@NotNull
	@Pattern(regexp="^[0-9]{2}")
	private Byte age;
	@NotNull
	@Pattern(regexp="^[0-9]{10}")
	private Long phoneNumber;
	@NotNull
	@Email
	private String emailId;
	@NotBlank
	@Pattern(regexp="^[a-z][A-Z][0-9][_-@#%&*$!]{6,15}")
	private String password;
	@NotNull
	private UserStatus userStatus;
	@NotBlank
	private LocalDate dateOfJoining;

	private Set<RoleDto> role;
	@JsonIgnoreProperties({"user","password","book","user"})
	private Set<FeedbackDto> feedbacks = new HashSet<>();
	@JsonIgnoreProperties({"user","password","approvedBy"})
	private Set<IssueRecordDto> issueRecords = new HashSet<>();
	public UserDto(Long userId, String mindId, String userName, Byte age, Long phoneNumber, String emailId,
			String password, UserStatus userStatus, LocalDate dateOfJoining, Set<RoleDto> role,
			Set<FeedbackDto> feedbacks, Set<IssueRecordDto> issueRecords) {
		super();
		this.userId = userId;
		this.mindId = mindId;
		this.userName = userName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.password = password;
		this.userStatus = userStatus;
		this.dateOfJoining = dateOfJoining;
		this.role = role;
		this.feedbacks = feedbacks;
		this.issueRecords = issueRecords;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @return the mindId
	 */
	public String getMindId() {
		return mindId;
	}

	/**
	 * @param mindId the mindId to set
	 */
	public void setMindId(String mindId) {
		this.mindId = mindId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	public Set<RoleDto> getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Set<RoleDto> role) {
		this.role = role;
	}

	/**
	 * @return the feedbacks
	 */
	public Set<FeedbackDto> getFeedbacks() {
		return feedbacks;
	}

	/**
	 * @param feedbacks the feedbacks to set
	 */
	public void setFeedbacks(Set<FeedbackDto> feedbacks) {
		this.feedbacks = feedbacks;
	}

	/**
	 * @return the issueRecords
	 */
	public Set<IssueRecordDto> getIssueRecords() {
		return issueRecords;
	}

	/**
	 * @param issueRecords the issueRecords to set
	 */
	public void setIssueRecords(Set<IssueRecordDto> issueRecords) {
		this.issueRecords = issueRecords;
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", mindId=" + mindId + ", userName=" + userName + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", password=" + password + ", userStatus="
				+ userStatus + ", dateOfJoining=" + dateOfJoining + ", role=" + role + ", feedbacks=" + feedbacks
				+ ", issueRecords=" + issueRecords + "]";
	}


}
