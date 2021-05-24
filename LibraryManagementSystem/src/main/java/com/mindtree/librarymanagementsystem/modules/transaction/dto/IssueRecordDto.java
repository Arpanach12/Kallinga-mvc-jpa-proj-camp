package com.mindtree.librarymanagementsystem.modules.transaction.dto;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;

public class IssueRecordDto {

	private Long issueId;

	private Long tokenId;
	private LocalDate issueDate;
	private LocalDate returnDate;
    @NotBlank
	private TokenStatus tokenStatus;

	private Byte reIssueCount;
	@JsonIgnoreProperties({"issueRecords","issueRecord","password","feedbacks"})

	private UserDto approvedBy;
	 @JsonIgnoreProperties({"authors","publisher","genre"})
	private Set<BookDto> books = new HashSet<>();
	@JsonIgnoreProperties({"issueRecords","issueRecord","password","feedbacks"})
	private UserDto user;

	public IssueRecordDto(Long issueId, Long tokenId, LocalDate issueDate, LocalDate returnDate,
			TokenStatus tokenStatus, Byte reIssueCount, UserDto approvedBy, Set<BookDto> books, UserDto user) {
		super();
		this.issueId = issueId;
		this.tokenId = tokenId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.tokenStatus = tokenStatus;
		this.reIssueCount = reIssueCount;
		this.approvedBy = approvedBy;
		this.books = books;
		this.user = user;
	}

	public IssueRecordDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the issueId
	 */
	public Long getIssueId() {
		return issueId;
	}

	/**
	 * @param issueId the issueId to set
	 */
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	/**
	 * @return the tokenId
	 */
	public Long getTokenId() {
		return tokenId;
	}

	/**
	 * @param tokenId the tokenId to set
	 */
	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}

	/**
	 * @return the issueDate
	 */
	public LocalDate getIssueDate() {
		return issueDate;
	}

	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return the returnDate
	 */
	public LocalDate getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the tokenStatus
	 */
	public TokenStatus getTokenStatus() {
		return tokenStatus;
	}

	/**
	 * @param tokenStatus the tokenStatus to set
	 */
	public void setTokenStatus(TokenStatus tokenStatus) {
		this.tokenStatus = tokenStatus;
	}

	/**
	 * @return the reIssueCount
	 */
	public Byte getReIssueCount() {
		return reIssueCount;
	}

	/**
	 * @param reIssueCount the reIssueCount to set
	 */
	public void setReIssueCount(Byte reIssueCount) {
		this.reIssueCount = reIssueCount;
	}

	/**
	 * @return the approvedBy
	 */
	public UserDto getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(UserDto approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * @return the books
	 */
	public Set<BookDto> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<BookDto> books) {
		this.books = books;
	}

	/**
	 * @return the user
	 */
	public UserDto getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "IssueRecordDto [issueId=" + issueId + ", tokenId=" + tokenId + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + ", tokenStatus=" + tokenStatus + ", reIssueCount=" + reIssueCount
				+ ", approvedBy=" + approvedBy + ", books=" + books + ", user=" + user + "]";
	}


}
