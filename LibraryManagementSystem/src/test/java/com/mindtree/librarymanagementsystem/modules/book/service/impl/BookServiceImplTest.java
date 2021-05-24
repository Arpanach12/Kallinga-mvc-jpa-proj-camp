//
//package com.mindtree.librarymanagementsystem.modules.book.service.impl;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.mindtree.librarymanagementsystem.modules.book.dto.AuthorDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.GenreDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.PublisherDto;
//import com.mindtree.librarymanagementsystem.modules.book.entity.Author;
//import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
//import com.mindtree.librarymanagementsystem.modules.book.entity.Genre;
//import com.mindtree.librarymanagementsystem.modules.book.entity.Publisher;
//import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
//import com.mindtree.librarymanagementsystem.modules.book.repository.AuthorRepository;
//import com.mindtree.librarymanagementsystem.modules.book.repository.BookRepository;
//import com.mindtree.librarymanagementsystem.modules.book.repository.GenreRepository;
//import com.mindtree.librarymanagementsystem.modules.book.repository.PublisherRepository;
//import com.mindtree.librarymanagementsystem.modules.book.service.BookService;
//import com.mindtree.librarymanagementsystem.modules.common.enums.BookStatus;
//import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
//import com.mindtree.librarymanagementsystem.modules.common.enums.UserStatus;
//import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
//import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;
//import com.mindtree.librarymanagementsystem.modules.transaction.repository.IssueRecordRepository;
//import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;
//import com.mindtree.librarymanagementsystem.modules.user.entity.User;
//import com.mindtree.librarymanagementsystem.modules.util.Util;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//public class BookServiceImplTest {
//	
////	@Autowired
////	private MockMvc mockMvc;
//
//	@InjectMocks
//	private BookServiceImpl bookServiceImpl1;
//
//	@Mock
//	private IssueRecordRepository issueRecordRepository;
//
//
//	@Mock
//	BookRepository bookRepository;
//	
//	@Mock
//	AuthorRepository authorRepository;
//	
//	@Autowired
//	ModelMapper modelmapper;
//	
//	@Mock
//	PublisherRepository publisherRepository;
//	
//	@Mock
//	GenreRepository genreRepository;
//
//	@Mock
//	private Util util;
//	
//	
//	@Autowired
//	BookService bookServiceImpl;
//	
//	@Test
//	public void testConvertDtoToBookEntity() {
//
//	}
//
//	@Test
//	public void testConvertUserEntityToDto() {
//
//	}
//
//	@Test
//	public void testConvertDtoToUserEntity() {
//
//	}
//
//	@Test
//	public void testConvertBookEntityToDto() {
//
//	}
//
//	@Test
//	public void testGetAllBooks() {
//
//	}
//
//	@Test
//	public void testDeleteBook() {
//
//	}
//
//	@Test
//	public void testGetAllBooksShouldBeReturn() {
//
//		
//	}
//
//	
//
//	@Test
//	public void testAddSingleBook() throws BookServiceException {
//		List<Book> books=new ArrayList<Book>();
//		PublisherDto publisherDto=new PublisherDto((long)1,"harald",null);
//		
//		GenreDto genreDto= new GenreDto((long)1,"fiction",null);
//		List<AuthorDto> listAuthorDto=new ArrayList<AuthorDto>();
//		AuthorDto authorDto1=new AuthorDto((long)1,"ROBIN",null);
//		Author author=modelmapper.map(authorDto1, Author.class);
//		author.setBooks(books);
//		AuthorDto authorDto2=new AuthorDto((long)2,"sharma",null);
//		listAuthorDto.add(authorDto1);
//		listAuthorDto.add(authorDto2);
//		
//	
//		
//		BookDto bookDto=new BookDto();
//		bookDto.setBookId((long)1);
//		bookDto.setBookTitle("Two States");
//		bookDto.setTotalPages(250);
//		bookDto.setPublishDate(LocalDate.of(2020, 01, 01));
//		bookDto.setBookStatus(BookStatus.AVAILABLE);
//		bookDto.setBookImageUrl("image");
//		bookDto.setTotalBookCount(2);
//		bookDto.setAvailableBookCount(1);
//		bookDto.setBookRating(4f);
//		bookDto.setAuthors(listAuthorDto);
//		bookDto.setGenre(genreDto);
//		bookDto.setPublisher(publisherDto);
//		
//		BookDto bookDto1=new BookDto();
//		bookDto1.setBookId((long)2);
//		bookDto1.setBookTitle("Two States");
//		bookDto1.setTotalPages(250);
//		bookDto1.setPublishDate(LocalDate.of(2020, 01, 01));
//		bookDto1.setBookStatus(BookStatus.AVAILABLE);
//		bookDto1.setBookImageUrl("image");
//		bookDto1.setTotalBookCount(2);
//		bookDto1.setAvailableBookCount(1);
//		bookDto1.setBookRating(4f);
//		bookDto1.setAuthors(listAuthorDto);
//		bookDto1.setGenre(genreDto);
//		bookDto1.setPublisher(publisherDto);
//		
//			
//		when(bookRepository.existsById(bookDto.getBookId())).thenReturn(true);
//		when(authorRepository.existsByAuthorName("ROBIN")).thenReturn(true);
//		when(authorRepository.findByAuthorName("ROBIN")).thenReturn(modelmapper.map(authorDto1, Author.class));
//		when(publisherRepository.existsBypublisherName("harald")).thenReturn(true);
//		when(publisherRepository.findByPublisherName("harald")).thenReturn(Optional.of(modelmapper.map(publisherDto, Publisher.class)));
//		when(genreRepository.existsBygenreName(genreDto.getGenreName())).thenReturn(true);
//		when(genreRepository.findByGenreName(genreDto.getGenreName())).thenReturn(Optional.of(modelmapper.map(genreDto, Genre.class)));
//		when(bookRepository.save(modelmapper.map(bookDto, Book.class))).thenReturn(modelmapper.map(bookDto, Book.class));
//		when(author.getBooks()).thenReturn(books);
//		when(books.add(modelmapper.map(bookDto, Book.class))).thenReturn(true);
//		assertEquals(null,bookServiceImpl.addSingleBook(bookDto1));
////        Set<Book>bookset=new HashSet<Book>();
////		List<Book> books=new ArrayList<Book>();
////		List<Author>authorlist=new ArrayList<Author>();
////		List<AuthorDto>authorlistdto=new ArrayList<AuthorDto>();
////		Book book=new Book(1L,"two states",1000,LocalDate.parse("2000-01-23"), BookStatus.AVAILABLE,"url of image",1000,900,(float)4,null,null,null,null);
////		books.add(book);
////		bookset.add(book);
////		AuthorDto authordto=new AuthorDto("xyz");
////		authorlistdto.add(authordto);
////		Author author=new Author(101L,"xyz", books);
////		authorlist.add(author);
////		Publisher publisher=new Publisher(100L,"abc", bookset);
////		PublisherDto publisherdto=new PublisherDto("abc");
////		Genre genre=new Genre(120L,"xyzabc",bookset);
////		GenreDto genredto=new GenreDto("xyzabc");
////		Book book1=new Book(1L,"two states",1000,LocalDate.parse("2000-01-23"), BookStatus.AVAILABLE,"url of image",1000,900,(float)4,authorlist,publisher, genre,null);
////		BookDto bookdto=new BookDto(1L,"two states",500,LocalDate.parse("2000-01-23"), BookStatus.AVAILABLE,"url of image",1000,900,(float)4,authorlistdto,publisherdto, genredto);
////		Mockito.when(authorRepository.findByAuthorName("xyz")).thenReturn(author);
////		Mockito.when(bookRepository.save(book1)).thenReturn(book1);
////		Mockito.when(util.convertBookEntityToDto(book1)).thenReturn(bookdto);
////		assertEquals(bookdto,bookServiceImpl1.addSingleBook(bookdto));
////		
//	}
//
//	@Test
//	public void testGetAllBooksByAuthor() {
//
//	}
//
//	@Test
//	public void testSaveAll() {
//
//		
//	}
//
//	@Test
//	public void testGetAllOverDueBooks() throws BookServiceException {
//	
//	List<User>user=new ArrayList<User>();	
//	Set<IssueRecord>issueset=new HashSet<>();	
//	Set<IssueRecordDto>issuesetdto=new HashSet<>();
//	
//	
//	IssueRecord issueRecordtemp=new IssueRecord(101L,111L,LocalDate.now().minusDays(20),LocalDate.now().minusDays(10),TokenStatus.CONFIRM,(byte)0,null,null,null);	
//	issueset.add(issueRecordtemp);
//	IssueRecordDto issuedto=new IssueRecordDto(101L,111L,LocalDate.now().minusDays(20),LocalDate.now().minusDays(10),TokenStatus.CONFIRM,(byte)0,null,null,null);
//	issuesetdto.add(issuedto);
//	User tempUser=new User("xyz",(byte)21,12345567L,"M10558XX@mindtree.com","123there",UserStatus.ACTIVE,LocalDate.parse("2019-10-12"),null,null,issueset);	
//	UserDto userdto=new UserDto(101L,"M1055XXX","xyz",(byte)21,12345567L,"M10558XX@mindtree.com","123there",UserStatus.ACTIVE,LocalDate.parse("2019-10-12"),null,null,issuesetdto);
//	
//
//	List<IssueRecord>issuelist=new ArrayList<IssueRecord>();	
//	IssueRecord issueRecord=new IssueRecord(101L,111L,LocalDate.now().minusDays(20),LocalDate.now().minusDays(10),TokenStatus.CONFIRM,(byte)0,null,null,null);
//	issuelist.add(issueRecord);
//	IssueRecord issueRecord1=new IssueRecord(102L,122L,LocalDate.now().minusDays(10),LocalDate.now(),TokenStatus.CONFIRM,(byte)1,null,null,null);
//	issuelist.add(issueRecord1);
//	IssueRecord issueRecord2=new IssueRecord(103L,133L,LocalDate.now().minusDays(10),LocalDate.now().plusDays(10),TokenStatus.CONFIRM,(byte)0,null,null,null);
//	issuelist.add(issueRecord2);
//	when(util.convertUserEntityToDto(tempUser)).thenReturn(userdto);
//	Mockito.when(issueRecordRepository.findAll()).thenReturn(issuelist);
//	assertEquals(1,bookServiceImpl1.getAllOverDueBooks().size());
//
//	}
//
//	@Test
//	public void testGetAllBooksByGenre() {
//
//	}
//
//	@Test
//	public void testGetAllBooksByBookName() {
//
//	}
//
//	@Test
//	public void testGetAllBooksByPublisher() {
//
//	}
//
//}
//
////package com.mindtree.librarymanagementsystem.modules.book.service.impl;
////
////import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.mockito.Mockito.when;
////
////import java.time.LocalDate;
////import java.util.ArrayList;
////import java.util.HashSet;
////import java.util.List;
////import java.util.Optional;
////import java.util.Set;
////import java.util.stream.Collectors;
////
////import org.junit.Test;
////import org.junit.runner.RunWith;
////import org.mockito.InjectMocks;
////import org.mockito.Mock;
////import org.mockito.Mockito;
////import org.modelmapper.ModelMapper;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
////import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.test.mock.mockito.MockBean;
////import org.springframework.test.context.junit4.SpringRunner;
////import org.springframework.test.web.servlet.MockMvc;
////
////import com.mindtree.librarymanagementsystem.modules.book.dto.AuthorDto;
////import com.mindtree.librarymanagementsystem.modules.book.dto.BookDateDto;
////import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
////import com.mindtree.librarymanagementsystem.modules.book.dto.GenreDto;
////import com.mindtree.librarymanagementsystem.modules.book.dto.PublisherDto;
////import com.mindtree.librarymanagementsystem.modules.book.entity.Author;
////import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
////import com.mindtree.librarymanagementsystem.modules.book.entity.Genre;
////import com.mindtree.librarymanagementsystem.modules.book.entity.Publisher;
////import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
////import com.mindtree.librarymanagementsystem.modules.book.repository.AuthorRepository;
////import com.mindtree.librarymanagementsystem.modules.book.repository.BookRepository;
////import com.mindtree.librarymanagementsystem.modules.book.repository.GenreRepository;
////import com.mindtree.librarymanagementsystem.modules.book.repository.PublisherRepository;
////import com.mindtree.librarymanagementsystem.modules.book.service.BookService;
////import com.mindtree.librarymanagementsystem.modules.common.enums.BookStatus;
////import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
////import com.mindtree.librarymanagementsystem.modules.common.enums.UserStatus;
////import com.mindtree.librarymanagementsystem.modules.transaction.dto.IssueRecordDto;
////import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;
////import com.mindtree.librarymanagementsystem.modules.transaction.repository.IssueRecordRepository;
////import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;
////import com.mindtree.librarymanagementsystem.modules.util.Util;
////
////@SpringBootTest
////@RunWith(SpringRunner.class)
////@AutoConfigureMockMvc
////public class BookServiceImplTest {
////
////	@Autowired
////	private MockMvc mockMvc;
////
////	@InjectMocks
////	private BookServiceImpl bookServiceImpl1;
////
////	@Mock
////	private IssueRecordRepository issueRecordRepository;
////
////	@Mock
////	BookRepository bookRepository;
////
////	@Mock
////	AuthorRepository authorRepository;
////
////	@Mock
////	PublisherRepository publisherRepository;
////
////	@Mock
////	GenreRepository genreRepository;
////
////	@Mock
////	private Util util;
////	
////	@Autowired
////	ModelMapper modelmapper;
////
////	
////
////	@Test
////	public void testGetAllOverDueBooks() throws BookServiceException {
////		List<IssueRecord> issuelist = new ArrayList<IssueRecord>();
////		IssueRecord issueRecord = new IssueRecord(101L, 111L, LocalDate.now().minusDays(20),
////				LocalDate.now().minusDays(10), TokenStatus.CONFIRM, (byte) 0, null, null, null);
////		issuelist.add(issueRecord);
////		IssueRecord issueRecord1 = new IssueRecord(102L, 122L, LocalDate.now().minusDays(10), LocalDate.now(),
////				TokenStatus.CONFIRM, (byte) 1, null, null, null);
////		issuelist.add(issueRecord1);
////		IssueRecord issueRecord2 = new IssueRecord(103L, 133L, LocalDate.now().minusDays(10),
////				LocalDate.now().plusDays(10), TokenStatus.CONFIRM, (byte) 0, null, null, null);
////		issuelist.add(issueRecord2);
////		Mockito.when(issueRecordRepository.findAll()).thenReturn(issuelist);
////		assertEquals(1, bookServiceImpl1.getAllOverDueBooks().size());
////
////	}
////
////	@Test
////	public void testGetAllBooksByGenre() throws BookServiceException {
////
////		List<Book> listBook = new ArrayList<Book>();
////
////		List<Author> listAuthor = new ArrayList<Author>();
////		listAuthor.add(new Author((long) 1, "ROBIN", null));
////		listAuthor.add(new Author((long) 2, "sharma", null));
////
////		Publisher publisher = new Publisher((long) 1, "harald", null);
////		Genre genre = new Genre((long) 1, "fiction", null);
////
////		Book book = new Book();
////		
////		book.setBookId((long) 1);
////		book.setBookTitle("Two States");
////		book.setTotalPages(250);
////		book.setPublishDate(LocalDate.of(2020, 01, 01));
////		book.setBookStatus(BookStatus.AVAILABLE);
////		book.setBookImageUrl("image");
////		book.setTotalBookCount(2);
////		book.setAvailableBookCount(1);
////		book.setBookRating(4f);
////		book.setAuthors(listAuthor);
////		book.setGenre(genre);
////		book.setPublisher(publisher);
////
////		listBook.add(book);
////
////		Set<BookDto> setBookDto = new HashSet<BookDto>();
////
////		List<AuthorDto> listAuthorDto = new ArrayList<AuthorDto>();
////		listAuthorDto.add(new AuthorDto((long) 1, "ROBIN", null));
////		listAuthorDto.add(new AuthorDto((long) 2, "sharma", null));
////
////		List<BookDateDto> listBookDto = new ArrayList<BookDateDto>();
////
////		PublisherDto publisherDto = new PublisherDto((long) 1, "harald", null);
////		GenreDto genreDto = new GenreDto((long) 1, "fiction", null);
////
////		BookDto bookDto = new BookDto();
////		bookDto.setBookId((long) 1);
////		bookDto.setBookTitle("Two States");
////		bookDto.setTotalPages(250);
////		bookDto.setPublishDate(LocalDate.of(2020, 01, 01));
////		bookDto.setBookStatus(BookStatus.AVAILABLE);
////		bookDto.setBookImageUrl("image");
////		bookDto.setTotalBookCount(2);
////		bookDto.setAvailableBookCount(1);
////		bookDto.setBookRating(4f);
////		bookDto.setAuthors(listAuthorDto);
////		bookDto.setGenre(genreDto);
////		bookDto.setPublisher(publisherDto);
////		// bookDto.setAvailableDate(LocalDate.of(2020, 01, 01));
////		setBookDto.add(bookDto);
////
////		UserDto userDto = new UserDto(1L, "m1056105", "shubham", (byte) 21, 7829875549L, "sdsaf@gmail.com", "dsdsaf",
////				UserStatus.ACTIVE, LocalDate.of(2019, 02, 02), null, null, null);
////		UserDto userDto1 = new UserDto(1L, "m1056108", "harish", (byte) 21, 7829775549L, "sdssaf@gmail.com", "dssdsaf",
////				UserStatus.ACTIVE, LocalDate.of(2019, 02, 02), null, null, null);
////		IssueRecordDto issueRecordDto = new IssueRecordDto();
////		IssueRecordDto issueRecordDto2 = new IssueRecordDto();
////		Set<IssueRecordDto> issueRecordDtos = new HashSet<IssueRecordDto>();
////		issueRecordDto.setIssueId(1234L);
////		issueRecordDto.setTokenId(9876L);
////		issueRecordDto.setIssueDate(LocalDate.of(2020, 01, 01));
////		issueRecordDto.setReturnDate(LocalDate.of(2020, 01, 10));
////		issueRecordDto.setTokenStatus(TokenStatus.OPEN);
////		issueRecordDto.setReIssueCount((byte) 1);
////		issueRecordDto.setApprovedBy(userDto1);
////		issueRecordDto.setBooks(setBookDto);
////		issueRecordDto.setUser(userDto);
////
////		issueRecordDto2.setIssueId(1235L);
////		issueRecordDto2.setTokenId(9877L);
////		issueRecordDto2.setIssueDate(LocalDate.of(2020, 01, 02));
////		issueRecordDto2.setReturnDate(LocalDate.of(2020, 01, 11));
////		issueRecordDto2.setTokenStatus(TokenStatus.OPEN);
////		issueRecordDto2.setReIssueCount((byte) 0);
////		issueRecordDto2.setApprovedBy(userDto1);
////		issueRecordDto2.setBooks(setBookDto);
////		issueRecordDto2.setUser(userDto);
////
////		issueRecordDtos.add(issueRecordDto);
////		issueRecordDtos.add(issueRecordDto2);
////
////		BookDateDto bookDateDto = new BookDateDto();
////		bookDateDto.setBookId((long) 1);
////		bookDateDto.setBookTitle("Two States");
////		bookDateDto.setTotalPages(250);
////		bookDateDto.setPublishDate(LocalDate.of(2020, 01, 01));
////		bookDateDto.setBookStatus(BookStatus.AVAILABLE);
////		bookDateDto.setBookImageUrl("image");
////		bookDateDto.setTotalBookCount(2);
////		bookDateDto.setAvailableBookCount(1);
////		bookDateDto.setBookRating(4f);
////		bookDateDto.setAuthors(listAuthorDto);
////		bookDateDto.setGenre(genreDto);
////		bookDateDto.setPublisher(publisherDto);
////		bookDateDto.setAvailableDate(LocalDate.of(2020, 01, 01));
////		listBookDto.add(bookDateDto);
////
////		List<IssueRecord> issueRecords = issueRecordDtos.stream()
////				.map(issue -> util.convertDtoToIssueRecordEntity(issue)).collect(Collectors.toList());
////		when(util.convertBookEntityToBookDateDto(book)).thenReturn(bookDateDto);
////		when(bookRepository.findAll()).thenReturn(listBook);
////		when(genreRepository.existsBygenreName("fiction")).thenReturn(true);
////		assertEquals(1, bookServiceImpl1.getAllBooksByGenre("fiction").size());
////
////	}
////
////	@Test
////	public void testGetAllBooksByBookName() {
////
////	}
////
////	@Test
////	public void testGetAllBooksByPublisher() {
////
////	}
////
////}
//
