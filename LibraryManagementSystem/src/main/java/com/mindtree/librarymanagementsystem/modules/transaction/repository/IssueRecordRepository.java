package com.mindtree.librarymanagementsystem.modules.transaction.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;

@Repository
public interface IssueRecordRepository extends JpaRepository<IssueRecord, Long>{



	public boolean existsByIssueId(int issueId);

	public Optional<IssueRecord> findByIssueId(Long issueRecordId);

	public boolean existsByTokenId(Long tokenId);

	public IssueRecord findByTokenId(Long tokenId);



}
