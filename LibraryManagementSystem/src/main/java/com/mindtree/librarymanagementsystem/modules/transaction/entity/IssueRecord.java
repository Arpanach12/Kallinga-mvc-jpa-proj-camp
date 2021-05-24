package com.mindtree.librarymanagementsystem.modules.transaction.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
import com.mindtree.librarymanagementsystem.modules.user.entity.User;

@Entity
@Table(name = "issueRecord")
public class IssueRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long issueId;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tokenId;
	private LocalDate issueDate;
	private LocalDate returnDate;
	@Enumerated(EnumType.STRING)
	private TokenStatus tokenStatus;
	private Byte reIssueCount;
	@ManyToOne
	@JoinColumn(name = "approver_id")
	private User approvedBy;

	// added
	@ManyToMany
	private Set<Book> books = new HashSet<>();
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public IssueRecord() {
		super();
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
	public User getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * @return the books
	 */
	public Set<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @param issueId
	 * @param tokenId
	 * @param issueDate
	 * @param returnDate
	 * @param tokenStatus
	 * @param reIssueCount
	 * @param approvedBy
	 * @param books
	 * @param user
	 */
	public IssueRecord(Long issueId, Long tokenId, LocalDate issueDate, LocalDate returnDate, TokenStatus tokenStatus,
			Byte reIssueCount, User approvedBy, Set<Book> books, User user) {
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

	@Override
	public String toString() {
		return "IssueRecord [issueId=" + issueId + ", tokenId=" + tokenId + ", issueDate=" + issueDate + ", returnDate="
				+ returnDate + ", tokenStatus=" + tokenStatus + ", reIssueCount=" + reIssueCount + ", approvedBy="
				+ approvedBy + ", books=" + books + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvedBy == null) ? 0 : approvedBy.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
		result = prime * result + ((issueId == null) ? 0 : issueId.hashCode());
		result = prime * result + ((reIssueCount == null) ? 0 : reIssueCount.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((tokenId == null) ? 0 : tokenId.hashCode());
		result = prime * result + ((tokenStatus == null) ? 0 : tokenStatus.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueRecord other = (IssueRecord) obj;
		if (approvedBy == null) {
			if (other.approvedBy != null)
				return false;
		} else if (!approvedBy.equals(other.approvedBy))
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
			return false;
		if (issueId == null) {
			if (other.issueId != null)
				return false;
		} else if (!issueId.equals(other.issueId))
			return false;
		if (reIssueCount == null) {
			if (other.reIssueCount != null)
				return false;
		} else if (!reIssueCount.equals(other.reIssueCount))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (tokenId == null) {
			if (other.tokenId != null)
				return false;
		} else if (!tokenId.equals(other.tokenId))
			return false;
		if (tokenStatus != other.tokenStatus)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
