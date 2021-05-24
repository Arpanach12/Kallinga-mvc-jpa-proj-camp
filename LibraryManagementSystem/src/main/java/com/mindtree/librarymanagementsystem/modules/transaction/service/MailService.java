package com.mindtree.librarymanagementsystem.modules.transaction.service;

import javax.mail.MessagingException;

import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;

public interface MailService {

	
	public void sendNotification(IssueRecord issueRecord);
	
	void sendEmailWithAttachment(IssueRecord issueRecord) throws MessagingException ;
}
