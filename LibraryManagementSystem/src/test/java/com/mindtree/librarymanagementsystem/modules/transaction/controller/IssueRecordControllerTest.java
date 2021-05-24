//package com.mindtree.librarymanagementsystem.modules.transaction.controller;
//
//
//import static org.junit.jupiter.api.Assertions.assertNotEquals;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import javax.mail.MessagingException;
//
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
//import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
//import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
//import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.TransactionServiceException;
//import com.mindtree.librarymanagementsystem.modules.transaction.service.impl.IssueRecordServiceImpl;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
//public class IssueRecordControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@InjectMocks
//	private IssueRecordController issueRecordController;
//
//	@Mock
//	private IssueRecordServiceImpl issueRecordServiceImpl;
//
//	@Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(issueRecordController).build();
//	}
//
//	@Test
//	void testDisplayAllRequests() throws TransactionServiceException {
//		IssueRecordDto issueRecordDto = new IssueRecordDto();
//		IssueRecordDto issueRecordDto2 = new IssueRecordDto();
//		Set<IssueRecordDto> issueRecordDtos = new HashSet<IssueRecordDto>();
//
//		issueRecordDto.setIssueId(1234L);
//		issueRecordDto.setTokenId(9876L);
//		issueRecordDto.setIssueDate(LocalDate.of(2020, 01, 01));
//		issueRecordDto.setReturnDate(LocalDate.of(2020, 01, 10));
//		issueRecordDto.setTokenStatus(TokenStatus.OPEN);
//		issueRecordDto.setReIssueCount((byte) 1);
//		issueRecordDto.setApprovedBy(null);
//		issueRecordDto.setBooks(null);
//		issueRecordDto.setUser(null);
//
//		issueRecordDto2.setIssueId(1235L);
//		issueRecordDto2.setTokenId(9877L);
//		issueRecordDto2.setIssueDate(LocalDate.of(2020, 01, 02));
//		issueRecordDto2.setReturnDate(LocalDate.of(2020, 01, 11));
//		issueRecordDto2.setTokenStatus(TokenStatus.OPEN);
//		issueRecordDto2.setReIssueCount((byte) 0);
//		issueRecordDto2.setApprovedBy(null);
//		issueRecordDto2.setBooks(null);
//		issueRecordDto2.setUser(null);
//
//		issueRecordDtos.add(issueRecordDto);
//		issueRecordDtos.add(issueRecordDto2);
//
//		when(issueRecordServiceImpl.retrieveAllRequests()).thenReturn(issueRecordDtos);
//		assertEquals(issueRecordDtos, issueRecordController.displayAllRequests().getBody().getBody());
//		assertNotEquals(1, issueRecordDtos.size());
//
//	}
//
//	IssueRecordDto issueRecordDto = new IssueRecordDto(1L, 1L, LocalDate.parse("1019-12-02"),
//			LocalDate.parse("2019-04-03"), TokenStatus.CONFIRM, (byte) 0, null, null, null);
//
//	@Test
//	public void testGetIssueRecord() throws TransactionServiceException {
//
//		when(issueRecordServiceImpl.getIssueRecord(1L)).thenReturn(issueRecordDto);
//		assertEquals(issueRecordDto, issueRecordController.getIssueRecord(1L).getBody().getBody());
//		assertEquals(issueRecordController.getIssueRecord(1L).getBody().isSuccess(), true);
//	}
//
//	@Test
//	void testDisplayTokenData() throws TransactionServiceException {
//
//		IssueRecordDto issueRecordDto = new IssueRecordDto();
//		IssueRecordDto issueRecordDto2 = new IssueRecordDto();
//		Set<IssueRecordDto> issueRecordDtos = new HashSet<IssueRecordDto>();
//		issueRecordDto.setIssueId(1234L);
//		issueRecordDto.setTokenId(9876L);
//		issueRecordDto.setIssueDate(LocalDate.of(2020, 01, 01));
//		issueRecordDto.setReturnDate(LocalDate.of(2020, 01, 10));
//		issueRecordDto.setTokenStatus(TokenStatus.OPEN);
//		issueRecordDto.setReIssueCount((byte) 1);
//		issueRecordDto.setApprovedBy(null);
//		issueRecordDto.setBooks(null);
//		issueRecordDto.setUser(null);
//
//		issueRecordDto2.setIssueId(1235L);
//		issueRecordDto2.setTokenId(9877L);
//		issueRecordDto2.setIssueDate(LocalDate.of(2020, 01, 02));
//		issueRecordDto2.setReturnDate(LocalDate.of(2020, 01, 11));
//		issueRecordDto2.setTokenStatus(TokenStatus.OPEN);
//		issueRecordDto2.setReIssueCount((byte) 0);
//		issueRecordDto2.setApprovedBy(null);
//		issueRecordDto2.setBooks(null);
//		issueRecordDto2.setUser(null);
//
//		issueRecordDtos.add(issueRecordDto);
//		issueRecordDtos.add(issueRecordDto2);
//
//		when(issueRecordServiceImpl.retrieveTokenData(9876L)).thenReturn(issueRecordDto);
//		assertEquals(issueRecordDto, issueRecordController.displayTokenData(9876L).getBody().getBody());
//		assertNotEquals(issueRecordDto2, issueRecordDto);
//	}
//
//}
