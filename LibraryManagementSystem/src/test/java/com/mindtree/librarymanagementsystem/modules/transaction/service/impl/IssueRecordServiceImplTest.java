//package com.mindtree.librarymanagementsystem.modules.transaction.service.impl;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import javax.mail.MessagingException;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
//import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
//import com.mindtree.librarymanagementsystem.modules.book.repository.BookRepository;
//import com.mindtree.librarymanagementsystem.modules.common.enums.BookStatus;
//import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
//import com.mindtree.librarymanagementsystem.modules.common.enums.UserStatus;
//import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
//import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;
//import com.mindtree.librarymanagementsystem.modules.transaction.exception.serviceexception.TransactionServiceException;
//import com.mindtree.librarymanagementsystem.modules.transaction.repository.IssueRecordRepository;
//import com.mindtree.librarymanagementsystem.modules.transaction.service.MailService;
//import com.mindtree.librarymanagementsystem.modules.user.entity.User;
//import com.mindtree.librarymanagementsystem.modules.user.repository.UserRepository;
//import com.mindtree.librarymanagementsystem.modules.util.Util;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
//public class IssueRecordServiceImplTest {
//
//	@Mock
//	private IssueRecordRepository issueRecordRepository;
//
//	@InjectMocks
//	private IssueRecordServiceImpl issueRecordServiceImpl;
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ModelMapper mapper;
//
//	@Mock
//	private Util util;
//
//	@Mock
//	private UserRepository userRepository;
//
//	@Mock
//	private BookRepository bookRepository;
//
//	@Mock
//	private MailService mailService;
//
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(issueRecordServiceImpl).build();
//	}
//
//	@Test
//	public void testRetrieveAllRequests() throws TransactionServiceException {
//		IssueRecord issueRecord = new IssueRecord();
//		IssueRecord issueRecord2 = new IssueRecord();
//		List<IssueRecord> issueRecords = new ArrayList<IssueRecord>();
//		issueRecord.setIssueId(1234L);
//		issueRecord.setTokenId(9876L);
//		issueRecord.setIssueDate(LocalDate.of(2020, 01, 01));
//		issueRecord.setReturnDate(LocalDate.of(2020, 01, 10));
//		issueRecord.setTokenStatus(TokenStatus.OPEN);
//		issueRecord.setReIssueCount((byte) 1);
//		issueRecord.setApprovedBy(null);
//		issueRecord.setBooks(null);
//		issueRecord.setUser(null);
//
//		issueRecord2.setIssueId(1235L);
//		issueRecord2.setTokenId(9877L);
//		issueRecord2.setIssueDate(LocalDate.of(2020, 01, 02));
//		issueRecord2.setReturnDate(LocalDate.of(2020, 01, 11));
//		issueRecord2.setTokenStatus(TokenStatus.OPEN);
//		issueRecord2.setReIssueCount((byte) 0);
//		issueRecord2.setApprovedBy(null);
//		issueRecord2.setBooks(null);
//		issueRecord2.setUser(null);
//
//		issueRecords.add(issueRecord);
//		issueRecords.add(issueRecord2);
//
//		IssueRecordDto issueRecordDto = new IssueRecordDto();
//
//		when(util.convertIssueRecordEntityToDto(issueRecord)).thenReturn(issueRecordDto);
//		when(issueRecordRepository.findAll()).thenReturn(issueRecords);
//		assertEquals(2, issueRecordServiceImpl.retrieveAllRequests().size());
//		assertNotEquals(3, issueRecordServiceImpl.retrieveAllRequests().size());
//	}
//
//	@Test
//	public void testGetReIssueRecord() {
//
//	}
//
//	@Test
//	public void testRetrieveTokenData() throws TransactionServiceException {
//		IssueRecord issueRecord = new IssueRecord();
//		IssueRecord issueRecord2 = new IssueRecord();
//		List<IssueRecord> issueRecordDtos = new ArrayList<IssueRecord>();
//		issueRecord.setIssueId(1234L);
//		issueRecord.setTokenId(9876L);
//		issueRecord.setIssueDate(LocalDate.of(2020, 01, 01));
//		issueRecord.setReturnDate(LocalDate.of(2020, 01, 10));
//		issueRecord.setTokenStatus(TokenStatus.OPEN);
//		issueRecord.setReIssueCount((byte) 1);
//		issueRecord.setApprovedBy(null);
//		issueRecord.setBooks(null);
//		issueRecord.setUser(null);
//
//		issueRecord2.setIssueId(1235L);
//		issueRecord2.setTokenId(9877L);
//		issueRecord2.setIssueDate(LocalDate.of(2020, 01, 02));
//		issueRecord2.setReturnDate(LocalDate.of(2020, 01, 11));
//		issueRecord2.setTokenStatus(TokenStatus.OPEN);
//		issueRecord2.setReIssueCount((byte) 0);
//		issueRecord2.setApprovedBy(null);
//		issueRecord2.setBooks(null);
//		issueRecord2.setUser(null);
//
//		issueRecordDtos.add(issueRecord);
//		issueRecordDtos.add(issueRecord2);
//
//		IssueRecordDto issueRecordDto = new IssueRecordDto();
//		IssueRecordDto issueRecordDto2 = mapper.map(issueRecord2, IssueRecordDto.class);
//		when(issueRecordRepository.existsByTokenId(9876L)).thenReturn(true);
//		when(issueRecordRepository.findByTokenId(9876L)).thenReturn(issueRecord);
//		when(util.convertIssueRecordEntityToDto(issueRecordRepository.findByTokenId(9876L))).thenReturn(issueRecordDto);
//		assertEquals(issueRecordDto, issueRecordServiceImpl.retrieveTokenData(9876L));
//		assertNotEquals(issueRecordDto2, issueRecordServiceImpl.retrieveTokenData(9876L));
//
//	}
//
//	Book book = new Book(1L, "Java", null, null, BookStatus.AVAILABLE, "sdfghfd", 3, 2, 3.4f, null, null, null, null);
//	Set<Book> books = new HashSet<Book>();
//
//	IssueRecord issueRecord = new IssueRecord(1L, 1L, LocalDate.parse("1019-12-02"), LocalDate.parse("2019-04-03"),
//			TokenStatus.CONFIRM, (byte) 0, null, books, null);
//
//	@Test
//	public void testGetIssueRecord() throws TransactionServiceException {
//		IssueRecordDto issueRecordDto = new IssueRecordDto(1L, 1L, LocalDate.parse("1019-12-02"),
//				LocalDate.parse("2019-04-03"), TokenStatus.CONFIRM, (byte) 0, null, null, null);
//
//		when(issueRecordRepository.findByIssueId(1L)).thenReturn(Optional.of(issueRecord));
//
//		when(util.convertIssueRecordEntityToDto(issueRecord)).thenReturn(issueRecordDto);
//		assertEquals(issueRecordServiceImpl.getIssueRecord(1L), issueRecordDto);
//	}
//
//	@Test
//	public void testChangeIssueRecordStatus()
//			throws BookServiceException, TransactionServiceException, MessagingException {
//		User user = new User("svf", (byte) 21, 24565432L, "dfewwb", "qdfgfds", UserStatus.ACTIVE,
//				LocalDate.parse("2019-02-02"), null, null, null);
//		books.add(book);
//		TokenStatus tokenStatus = TokenStatus.CLOSE;
//		IssueRecordDto issueRecordDto = new IssueRecordDto(1L, 1L, LocalDate.parse("1019-12-02"),
//				LocalDate.parse("2019-04-03"), TokenStatus.CONFIRM, (byte) 0, null, null, null);
//
//		when(issueRecordRepository.saveAndFlush(issueRecord)).thenReturn(issueRecord);
//		when(issueRecordRepository.findById(1L)).thenReturn(Optional.of(issueRecord));
//		when(userRepository.getOne(1L)).thenReturn(user);
//
//		when(bookRepository.getOne(2344L)).thenReturn(book);
//		when(bookRepository.saveAndFlush(book)).thenReturn(book);
//		for (Book bookObj : issueRecord.getBooks()) {
//			when(bookRepository.getOne(bookObj.getBookId())).thenReturn(book);
//
//			book.setAvailableBookCount(book.getAvailableBookCount() - 1);
//			when(bookRepository.saveAndFlush(book)).thenReturn(book);
//		}
//
//		IssueRecord issueRecordObj = new IssueRecord(1L, 1L, LocalDate.parse("1019-12-02"),
//				LocalDate.parse("2019-04-03"), TokenStatus.OPEN, (byte) 0, null, books, null);
//
//		when(util.convertIssueRecordEntityToDto(issueRecord)).thenReturn(issueRecordDto);
//
//		assertEquals(issueRecordServiceImpl.changeIssueRecordStatus(TokenStatus.CLOSE, 1L, 2L), issueRecordDto);
//
//		assertEquals(issueRecordServiceImpl.changeIssueRecordStatus(TokenStatus.CONFIRM, 1L, 2L), issueRecordDto);
//
//	}
//
//}
