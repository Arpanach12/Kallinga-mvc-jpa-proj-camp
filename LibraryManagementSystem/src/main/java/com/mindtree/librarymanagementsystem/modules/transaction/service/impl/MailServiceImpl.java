package com.mindtree.librarymanagementsystem.modules.transaction.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;
import com.mindtree.librarymanagementsystem.modules.transaction.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	private JavaMailSender javaMailSender;

	public MailServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;

	}

	@Override
	public void sendNotification(IssueRecord issueRecord) {

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(issueRecord.getUser().getEmailId());
		mailMessage.setFrom("KalingaLibrary");
		mailMessage.setSubject("Token Info");
		String bookName1 = "";
		String bookName2 = "";
		int count = 1;
		for (Book book : issueRecord.getBooks()) {
			if (count == 1) {
				bookName1 = book.getBookTitle();
				count++;
			} else
				bookName2 = book.getBookTitle();

		}
		mailMessage.setText("Token Id : " + issueRecord.getTokenId() + "\n" + "Book Name 1: " + bookName1 + "\n"
				+ "Book Name 2: " + bookName2 + "\n" + "Return Date: " + issueRecord.getReturnDate() + "\n"
				+ "Approved By: " + issueRecord.getApprovedBy().getFullName());

		
		
		
		
		javaMailSender.send(mailMessage);
	}

	@Override
	public void sendEmailWithAttachment(IssueRecord issueRecord) throws MessagingException {
		
		 MimeMessage msg = javaMailSender.createMimeMessage();

	        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	        helper.setTo(issueRecord.getUser().getEmailId());
	        helper.setFrom(new InternetAddress("Kalinga"));
	        helper.setSubject("Kalinga Library");

	        List<Book>  books=new ArrayList<Book>(issueRecord.getBooks());
	        if(books.size()==1) {
	        	books.add(new Book());
	        }
	        
	        // default = text/plain
	        //helper.setText("Check attachment for image!");

	        // true = text/html
	        helper.setText(" <fieldset>\r\n" + 
	        		"        <legend>\r\n" + 
	        		"            <h2>\r\n" + 
	        		"                Book Request</h2>\r\n" + 
	        		"        </legend>\r\n" + 
	        		"        <hr height=\"1px\">\r\n" + 
	        		"        <table width=\"100%\">\r\n" + 
	        		"            <tbody><tr>\r\n" + 
	        		"                <td colspan=\"4\">\r\n" + 
	        		"                    <span  style=\"color:Red;font-weight:bold;\"></span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"            </tr>\r\n" + 
	        		"            <tr>\r\n" + 
	        		"                <td width=\"200px\">\r\n" + 
	        		"                    <label>\r\n" + 
	        		"                        Token No :</label>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td class=\"style1\">\r\n" + 
	        		"                    <span>"+issueRecord.getIssueId()+"</span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td width=\"200px\">\r\n" + 
	        		"                    <label>\r\n" + 
	        		"                        Order Date :</label>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td>\r\n" + 
	        		"                    <span >"+issueRecord.getIssueDate()+"</span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"            </tr>\r\n" + 
	        		"            <tr>\r\n" + 
	        		"                <td>\r\n" + 
	        		"                    <label>\r\n" + 
	        		"                        Campus Mind :</label>\r\n" + 
	        		"                    <span>*</span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td>\r\n" + 
	        		"                    <span >"+issueRecord.getUser().getFullName()+"</span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td>\r\n" + 
	        		"                    <label>\r\n" + 
	        		"                        Approved By :</label>\r\n" + 
	        		"                    <span>*</span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td>\r\n" + 
	        		"                    <span >"+issueRecord.getApprovedBy().getFullName()+"</span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                \r\n" + 
	        		"            </tr>\r\n" + 
	        		"            <tr>\r\n" + 
	        		"                <td valign=\"top\">\r\n" + 
	        		"                    <label>\r\n" + 
	        		"                        Status :</label>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td valign=\"top\">\r\n" + 
	        		"                    <span  style=\"color:Red;font-weight:bold;\">"+issueRecord.getTokenStatus()+"</span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td width=\"200px\">\r\n" + 
	        		"                    <label>\r\n" + 
	        		"                        Return Date :</label>\r\n" + 
	        		"                </td>\r\n" + 
	        		"                <td>\r\n" + 
	        		"                    <span >"+issueRecord.getReturnDate()+"</span>\r\n" + 
	        		"                </td>\r\n" + 
	        		"            </tr>\r\n" + 
	        		"            \r\n" + 
	        		"        </tbody></table>\r\n" + 
	        		"        \r\n" + 
	        		"        <hr height=\"1px\">\r\n" + 
	        		"        <table style=\"width: 100%\">\r\n" + 
	        		"            <thead>\r\n" + 
	        		"                <tr>\r\n" + 
	        		"                    <th>Book Name</th>\r\n" + 
	        		"                    <th>Genre</th>\r\n" + 
	        		"                </tr>\r\n" + 
	        		"            </thead>\r\n" + 
	        		"\r\n" + 
	        		"            <tbody>\r\n" + 
	        		"                <tr>\r\n" + 
	        		"                    <td>"+books.get(0).getBookTitle()+"</td>\r\n" + 
	        		"                    <td>--------</td>\r\n" + 
	        		"                </tr>\r\n" + 
	        		"                <tr>\r\n" + 
	        		"                    <td>"+books.get(1).getBookTitle()+"</td>\r\n" + 
	        		"                    <td>--------</td>\r\n" + 
	        		"                </tr>\r\n" +
	        		"            </tbody>\r\n" + 
	        		"        </table>\r\n" + 
	        		"    </fieldset>", true);
	        

	       // helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

	        javaMailSender.send(msg);
		
	}

}
