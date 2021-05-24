
//package com.mindtree.librarymanagementsystem.modules.book.controller;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.stubbing.OngoingStubbing;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.mindtree.librarymanagementsystem.modules.book.dto.AuthorDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.BookDateDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.GenreDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.PublisherDto;
//import com.mindtree.librarymanagementsystem.modules.book.exception.BookException;
//import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
//import com.mindtree.librarymanagementsystem.modules.book.service.impl.BookServiceImpl;
//import com.mindtree.librarymanagementsystem.modules.common.enums.BookStatus;
//import com.mindtree.librarymanagementsystem.modules.common.enums.UserStatus;
//import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
//class BookControllerTest {
//	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	@InjectMocks
//	private BookController bookController;
//	
//	@Mock
//	private BookServiceImpl bookServiceImpl;
//
//	@org.junit.Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//	}
//
//
//
//	@Test
//	void testAddBookBookDtoErrors() throws BookServiceException, MethodArgumentNotValidException {
//		
//		PublisherDto publisherDto=new PublisherDto((long)1,"harald",null);
//		GenreDto genreDto= new GenreDto((long)1,"fiction",null);
//		List<AuthorDto> listAuthorDto=new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long)1,"ROBIN",null) );
//		listAuthorDto.add(new AuthorDto((long)2,"sharma",null) );
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
//		when(bookServiceImpl.addSingleBook(bookDto)).thenReturn(bookDto);
//		
//		assertEquals(bookDto, bookController.addSingleBook(bookDto).getBody().getBody());
//
//		
//	}
//
//	@Test
//	public void testGetAllBooks() {
//				
//		List<BookDateDto> listBookDto=new ArrayList<BookDateDto>();
//		
//		List<AuthorDto> listAuthorDto=new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long)1,"ROBIN",null) );
//		listAuthorDto.add(new AuthorDto((long)2,"sharma",null) );
//		
//		
//		PublisherDto publisherDto=new PublisherDto((long)1,"harald",null);
//		GenreDto genreDto= new GenreDto((long)1,"fiction",null);
//		
//		
//		BookDateDto bookDto=new BookDateDto();
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
//		bookDto.setAvailableDate(LocalDate.of(2020, 01, 01));
//		listBookDto.add(bookDto);
//		
//		
//		
//		when(bookServiceImpl.getAllBooks()).thenReturn(listBookDto);
//		assertEquals(listBookDto,bookController.retrieveBooks().getBody().getBody());	
//		
//		
//
//	}
//
//	@Test
//	void testGetAllBooksString() {
//		
//	}
//
//	@Test
//	void testGetAllBooksByGenre() {
//		
//	}
//
//	@Test
//	void testGetAllBooksByBookName() {
//
//	}
//
//	@Test
//	void testGetAllBooksByPublisher() {
//		
//	}
//
//	@Test
//	public void testGetAllOverDueBooks() throws BookServiceException {
//		List<UserDto>tempuserdto=new ArrayList<>();
//		UserDto userdto=new UserDto(101L,"M1055XXX" ,"xxx",(byte)21,123456L,"mind1@mindtree.com","abcABC", UserStatus.ACTIVE,LocalDate.parse("2019-10-12"),null, null, null);
//		tempuserdto.add(userdto);
//		UserDto userdto1=new UserDto(102L,"M1056XXX" ,"yyy",(byte)20,678890L,"mind2@mindtree.com","ABCabc", UserStatus.ACTIVE,LocalDate.parse("2019-10-11"),null, null, null);
//		tempuserdto.add(userdto1);
//		Mockito.when(bookServiceImpl.getAllOverDueBooks()).thenReturn(tempuserdto);
//		assertEquals(tempuserdto, bookController.getAllOverDueBooks().getBody().getBody());
//	}
//
//	
//		
//	@Test
//	void testAddAllBooks() throws BookServiceException, IOException, IOException {
//		
//		List<BookDto> bookDtos=new ArrayList<BookDto>();
//		
//		PublisherDto publisherDto=new PublisherDto((long)1,"harald",null);
//		GenreDto genreDto= new GenreDto((long)1,"fiction",null);
//		List<AuthorDto> listAuthorDto=new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long)1,"ROBIN",null) );
//		listAuthorDto.add(new AuthorDto((long)2,"sharma",null) );
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
//		bookDtos.add(bookDto);
//		MultipartFile file = new MockMultipartFile("test.xlsx", new FileInputStream(new File("D://test.xlsx")));
//		when(bookServiceImpl.saveAll(file)).thenReturn(bookDtos);
//		assertEquals(bookDtos, bookController.addAllBooks(file).getBody().getBody());
//
//	}
//
//	@Test
//	public void testGetBookLocalDate() throws BookException {
//		 LocalDate date=LocalDate.parse("2019-12-25");
//		Set<BookDto>bookdto=new HashSet<BookDto>();
//		BookDto bookdto1=new BookDto(101L,"xyz",1000,LocalDate.parse("2000-01-12"),BookStatus.AVAILABLE,"url of image",1000,900,(float)4,null,null,null);
//		bookdto.add(bookdto1);
//		BookDto bookdto2=new BookDto(102L,"abc",2000,LocalDate.parse("2000-01-12"),BookStatus.AVAILABLE,"url of image",2000,400,(float)3,null,null,null);
//	    bookdto.add(bookdto2);
//	    when(bookServiceImpl.getAllBooksShouldBeReturn(date)).thenReturn(bookdto);
//	    assertEquals(bookdto,bookController.getBook(date).getBody().getBody());
//	}
//	
//	@Test
//	void testGetBook() {
//		
//	}
//
//	@Test
//	void testAddBookLong() {
//
//	}
//
//}

//package com.mindtree.librarymanagementsystem.modules.book.controller;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.mindtree.librarymanagementsystem.modules.book.dto.AuthorDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.BookDateDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.GenreDto;
//import com.mindtree.librarymanagementsystem.modules.book.dto.PublisherDto;
//import com.mindtree.librarymanagementsystem.modules.book.exception.BookException;
//import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
//import com.mindtree.librarymanagementsystem.modules.book.service.impl.BookServiceImpl;
//import com.mindtree.librarymanagementsystem.modules.common.enums.BookStatus;
//import com.mindtree.librarymanagementsystem.modules.common.enums.UserStatus;
//import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;
//
//@SpringBootTest
//@RunWith(SpringJUnit4ClassRunner.class)
//@AutoConfigureMockMvc
//class BookControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@InjectMocks
//	private BookController bookController;
//
//	@Mock
//	private BookServiceImpl bookServiceImpl;
//
//	@org.junit.Before
//	public void setUp() throws Exception {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
//	}
//
//	@Test
//	void testAddBookBookDtoErrors() throws BookServiceException, MethodArgumentNotValidException {
//
//		PublisherDto publisherDto = new PublisherDto((long) 1, "harald", null);
//		GenreDto genreDto = new GenreDto((long) 1, "fiction", null);
//		List<AuthorDto> listAuthorDto = new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long) 1, "ROBIN", null));
//		listAuthorDto.add(new AuthorDto((long) 2, "sharma", null));
//
//		BookDto bookDto = new BookDto();
//		bookDto.setBookId((long) 1);
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
//		when(bookServiceImpl.addSingleBook(bookDto)).thenReturn(bookDto);
//
//		assertEquals(bookDto, bookController.addSingleBook(bookDto).getBody().getBody());
//
//	}
//
//	@Test
//	public void testGetAllBooks() {
//
//		List<BookDateDto> listBookDto = new ArrayList<BookDateDto>();
//
//		List<AuthorDto> listAuthorDto = new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long) 1, "ROBIN", null));
//		listAuthorDto.add(new AuthorDto((long) 2, "sharma", null));
//
//		PublisherDto publisherDto = new PublisherDto((long) 1, "harald", null);
//		GenreDto genreDto = new GenreDto((long) 1, "fiction", null);
//
//		BookDateDto bookDto = new BookDateDto();
//		bookDto.setBookId((long) 1);
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
//		bookDto.setAvailableDate(LocalDate.of(2020, 01, 01));
//		listBookDto.add(bookDto);
//
//		when(bookServiceImpl.getAllBooks()).thenReturn(listBookDto);
//		assertEquals(listBookDto, bookController.retrieveBooks().getBody().getBody());
//
//	}
//
//	@Test
//	void testGetAllBooksString() {
//
//		List<BookDateDto> listBookDto = new ArrayList<BookDateDto>();
//
//		List<AuthorDto> listAuthorDto = new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long) 1, "ROBIN", null));
//		listAuthorDto.add(new AuthorDto((long) 2, "sharma", null));
//
//		PublisherDto publisherDto = new PublisherDto((long) 1, "harald", null);
//		GenreDto genreDto = new GenreDto((long) 1, "fiction", null);
//
//		BookDateDto bookDto = new BookDateDto();
//		bookDto.setBookId((long) 1);
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
//		bookDto.setAvailableDate(LocalDate.of(2020, 01, 01));
//		listBookDto.add(bookDto);
//
//		when(bookServiceImpl.getAllBooksByAuthor("ROBIN")).thenReturn(listBookDto);
//		assertEquals(listBookDto, bookController.fetchBooksByAuthor("ROBIN").getBody().getBody());
//
//	}
//
//	@Test
//	void testGetAllBooksByGenre() throws BookException {
//
//		List<BookDateDto> listBookDto = new ArrayList<BookDateDto>();
//
//		List<AuthorDto> listAuthorDto = new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long) 1, "ROBIN", null));
//		listAuthorDto.add(new AuthorDto((long) 2, "sharma", null));
//
//		PublisherDto publisherDto = new PublisherDto((long) 1, "harald", null);
//		GenreDto genreDto = new GenreDto((long) 1, "fiction", null);
//
//		BookDateDto bookDto = new BookDateDto();
//		bookDto.setBookId((long) 1);
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
//		bookDto.setAvailableDate(LocalDate.of(2020, 01, 01));
//		listBookDto.add(bookDto);
//
//		when(bookServiceImpl.getAllBooksByGenre("fiction")).thenReturn(listBookDto);
//		assertEquals(listBookDto, bookController.fetchBooksByGenre("fiction").getBody().getBody());
//
//	}
//
//	@Test
//
//	void testGetAllBooksByBookName() throws BookException {
//
//		List<BookDateDto> listBookDto = new ArrayList<BookDateDto>();
//
//		List<AuthorDto> listAuthorDto = new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long) 1, "ROBIN", null));
//		listAuthorDto.add(new AuthorDto((long) 2, "sharma", null));
//
//		PublisherDto publisherDto = new PublisherDto((long) 1, "harald", null);
//		GenreDto genreDto = new GenreDto((long) 1, "fiction", null);
//
//		BookDateDto bookDto = new BookDateDto();
//		bookDto.setBookId((long) 1);
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
//		bookDto.setAvailableDate(LocalDate.of(2020, 01, 01));
//		listBookDto.add(bookDto);
//
//		when(bookServiceImpl.getAllBooksByBookName("Two States")).thenReturn(listBookDto);
//		assertEquals(listBookDto, bookController.fetchBookByName("Two States").getBody().getBody());
//
//	}
//
//	@Test
//	void testGetAllBooksByPublisher() throws BookException {
//
//		List<BookDateDto> listBookDto = new ArrayList<BookDateDto>();
//
//		List<AuthorDto> listAuthorDto = new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long) 1, "ROBIN", null));
//		listAuthorDto.add(new AuthorDto((long) 2, "sharma", null));
//
//		PublisherDto publisherDto = new PublisherDto((long) 1, "harald", null);
//		GenreDto genreDto = new GenreDto((long) 1, "fiction", null);
//
//		BookDateDto bookDto = new BookDateDto();
//		bookDto.setBookId((long) 1);
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
//		bookDto.setAvailableDate(LocalDate.of(2020, 01, 01));
//		listBookDto.add(bookDto);
//
//		when(bookServiceImpl.getAllBooksByPublisher("harald")).thenReturn(listBookDto);
//		assertEquals(listBookDto, bookController.fetchBooksByPublisher("harald").getBody().getBody());
//
//	}
//
//	@Test
//	public void testGetAllOverDueBooks() throws BookServiceException {
//		List<UserDto> tempuserdto = new ArrayList<>();
//		UserDto userdto = new UserDto(101L, "M1055XXX", "xxx", (byte) 21, 123456L, "mind1@mindtree.com", "abcABC",
//				UserStatus.ACTIVE, LocalDate.parse("2019-10-12"), null, null, null);
//		tempuserdto.add(userdto);
//		UserDto userdto1 = new UserDto(102L, "M1056XXX", "yyy", (byte) 20, 678890L, "mind2@mindtree.com", "ABCabc",
//				UserStatus.ACTIVE, LocalDate.parse("2019-10-11"), null, null, null);
//		tempuserdto.add(userdto1);
//		Mockito.when(bookServiceImpl.getAllOverDueBooks()).thenReturn(tempuserdto);
//		assertEquals(tempuserdto, bookController.getAllOverDueBooks().getBody().getBody());
//	}
//
//	@Test
//	void testAddAllBooks() throws BookServiceException, IOException, IOException {
//
//		List<BookDto> bookDtos = new ArrayList<BookDto>();
//
//		PublisherDto publisherDto = new PublisherDto((long) 1, "harald", null);
//		GenreDto genreDto = new GenreDto((long) 1, "fiction", null);
//		List<AuthorDto> listAuthorDto = new ArrayList<AuthorDto>();
//		listAuthorDto.add(new AuthorDto((long) 1, "ROBIN", null));
//		listAuthorDto.add(new AuthorDto((long) 2, "sharma", null));
//
//		BookDto bookDto = new BookDto();
//		bookDto.setBookId((long) 1);
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
//		bookDtos.add(bookDto);
//		
//		File file1 = mock(File.class); 
//        when(file1.exists()).thenReturn(true); 
//        when(file1.canRead()).thenReturn(true); 
//       
//        FileInputStream fileStream = mock(FileInputStream.class); 
//		
//		MultipartFile file = new MockMultipartFile("test.xlsx", fileStream);
//		when(bookServiceImpl.saveAll(file)).thenReturn(bookDtos);
//		//assertEquals(bookDtos, bookController.addAllBooks(file).getBody().getBody());
//
//	}
//
//	@Test
//	void testGetBookLocalDate() {
//
//	}
//
//	@Test
//	void testGetBook() {
//
//	}
//
//	@Test
//	void testAddBookLong() {
//
//	}
//}

