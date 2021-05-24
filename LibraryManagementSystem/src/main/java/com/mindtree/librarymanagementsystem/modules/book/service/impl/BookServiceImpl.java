package com.mindtree.librarymanagementsystem.modules.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.book.repository.BookRepository;
import com.mindtree.librarymanagementsystem.modules.book.service.BookService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mindtree.librarymanagementsystem.modules.book.dto.AuthorDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.BookDateDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.GenreDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.PublisherDto;
import com.mindtree.librarymanagementsystem.modules.book.entity.Author;
import com.mindtree.librarymanagementsystem.modules.book.entity.Book;
import com.mindtree.librarymanagementsystem.modules.book.entity.Genre;
import com.mindtree.librarymanagementsystem.modules.book.entity.Publisher;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookAlreadyExistsException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookNotFoundException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.GenreNotFoundException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.NoOverDueRecordFound;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.PublisherNotFoundException;
import com.mindtree.librarymanagementsystem.modules.book.repository.AuthorRepository;
import com.mindtree.librarymanagementsystem.modules.book.repository.BookRepository;
import com.mindtree.librarymanagementsystem.modules.book.repository.GenreRepository;
import com.mindtree.librarymanagementsystem.modules.book.repository.PublisherRepository;
import com.mindtree.librarymanagementsystem.modules.book.service.BookService;
import com.mindtree.librarymanagementsystem.modules.common.enums.BookStatus;
import com.mindtree.librarymanagementsystem.modules.common.enums.TokenStatus;
import com.mindtree.librarymanagementsystem.modules.transaction.entity.IssueRecord;
import com.mindtree.librarymanagementsystem.modules.transaction.repository.IssueRecordRepository;
import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;
import com.mindtree.librarymanagementsystem.modules.user.entity.User;
import com.mindtree.librarymanagementsystem.modules.util.Util;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private Util util;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IssueRecordRepository issueRecordRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private GenreRepository genreRepository;

	public Book convertDtoToBookEntity(BookDto bookDto) {
		return modelMapper.map(bookDto, Book.class);
	}

	

	public BookDto convertBookEntityToDto(Book book) {

		return modelMapper.map(book, BookDto.class);
	}

	@Override
	public List<BookDateDto> getAllBooks() {
		List<BookDateDto> bookDateDto = bookRepository.findAll().stream()
				.map(book -> modelMapper.map(book, BookDateDto.class)).collect(Collectors.toList());
		LocalDate availableDate = LocalDate.now().plusDays(10);

		for (BookDateDto books : bookDateDto) {
			if (books.getAvailableBookCount() == 0) {
				for (IssueRecord issue : issueRecordRepository.findAll()) {
					if (issue.getTokenStatus().equals(TokenStatus.CONFIRM)) {
						for (Book book : issue.getBooks()) {
							if (book.getBookTitle().equals(books.getBookTitle())) {
								if (availableDate.isAfter(issue.getReturnDate())) {
									books.setAvailableDate(issue.getReturnDate());
									availableDate = issue.getReturnDate();
								}
							}
						}
					}
				}
			} else {
				books.setAvailableDate(LocalDate.now());
			}
		}

		return bookDateDto;
	}

//assigning a book to does not existing
	@Override

	public String deleteBook(long bookId) throws BookServiceException {
		Book book = bookRepository.findById(bookId).get();
		if (book.getBookStatus().equals(BookStatus.DOES_NOT_EXIST))
			throw new BookNotFoundException("book does not exist");
		else
			book.setBookStatus(BookStatus.DOES_NOT_EXIST);
		bookRepository.save(book);
		return "deleted";

	}

	// show the books whose return date is the given date
	@Override
	public Set<BookDto> getAllBooksShouldBeReturn(LocalDate particularDate) throws BookServiceException {
		Set<Book> books = new HashSet<Book>();
		Set<BookDto> bookdto = new HashSet<BookDto>();
		List<IssueRecord> issueRecords = issueRecordRepository.findAll();
		int count = 0;
		for (IssueRecord issueRecord : issueRecords) {
			LocalDate date = issueRecord.getReturnDate();
			if (particularDate.isEqual(date)) {
				issueRecord.getBooks().forEach(i -> books.add(i));
			} else {
				count++;

			}
		}
		if (count == issueRecords.size())
			throw new BookNotFoundException("No books to be returned");

		bookdto = books.stream().map(bookentity -> convertEntityToDto(bookentity)).collect(Collectors.toSet());

		return bookdto;
	}

	private Book convertDtoToEntity(BookDto bookdto) {
		return modelMapper.map(bookdto, Book.class);
	}

	private BookDto convertEntityToDto(Book book) {

		return modelMapper.map(book, BookDto.class);
	}

	public BookDto addSingleBook(BookDto bookDto) throws BookServiceException {

		Book book = util.convertDtoToBookEntity(bookDto);

		if (bookRepository.existsById(bookDto.getBookId())) {
			throw new BookAlreadyExistsException("Book is already There !!");
		}

		
		List<Author> authors = new ArrayList<Author>();
		for (Author author : book.getAuthors()) {

			if (authorRepository.existsByAuthorName(author.getAuthorName())) {
				author = authorRepository.findByAuthorName(author.getAuthorName());
				author.getBooks().add(book);
			} else {
				author.getBooks().add(book);

			}
			authors.add(author);

		}
		book.setAuthors(authors);

		Publisher publisher = book.getPublisher();
		if (publisherRepository.existsByPublisherName(publisher.getPublisherName())) {

			publisher = publisherRepository.findByPublisherName(publisher.getPublisherName()).get();
			book.setPublisher(publisher);
		}

		Genre genre = book.getGenre();
		if (genreRepository.existsByGenreName(genre.getGenreName())) {
			genre = genreRepository.findByGenreName(genre.getGenreName()).get();
			book.setGenre(genre);

		}

		book.setBookStatus(BookStatus.AVAILABLE);
		book.setAvailableBookCount(bookDto.getTotalBookCount());
		book = bookRepository.save((book));

		return util.convertBookEntityToDto(book);

	}

	@Override
	public List<BookDateDto> getAllBooksByAuthor(String authorName) {

		List<Book> bookList = new ArrayList<Book>();

		bookRepository.findAll().forEach(book -> {
			book.getAuthors().forEach(authorObj -> {

				if (authorObj.getAuthorName().equalsIgnoreCase(authorName))

					bookList.add(book);
			});
		});
		List<BookDateDto> bookDateDto = new ArrayList<>();
		bookDateDto = bookList.stream().map(book -> modelMapper.map(book, BookDateDto.class))
				.collect(Collectors.toList());
		LocalDate availableDate = LocalDate.now().plusDays(10);

		for (BookDateDto books : bookDateDto) {
			if (books.getAvailableBookCount() == 0) {
				for (IssueRecord issue : issueRecordRepository.findAll()) {
					if (issue.getTokenStatus().equals(TokenStatus.CONFIRM)) {
						for (Book book : issue.getBooks()) {
							if (book.getBookTitle().equals(books.getBookTitle())) {
								if (availableDate.isAfter(issue.getReturnDate())) {
									books.setAvailableDate(issue.getReturnDate());
									availableDate = issue.getReturnDate();
								}
							}
						}
					}
				}
			} else {
				books.setAvailableDate(LocalDate.now());
			}
		}

		return bookDateDto;
	}

	@Override
	public List<BookDto> saveAll(MultipartFile file) throws BookServiceException {

		List<BookDto> bookDtos = new ArrayList<BookDto>();
		Workbook workbook = null;
		try {

			workbook = new XSSFWorkbook(file.getInputStream());
			Sheet sheet = workbook.getSheetAt(0);

			int i = 0;
			for (Row row : sheet) {
				if (i > 0) {

					LocalDate publisDate = null;
					if (!row.getCell(2).getStringCellValue().isEmpty()
							&& row.getCell(2).getStringCellValue().length() > 7) {
						DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
						publisDate = LocalDate.parse(row.getCell(2).getStringCellValue(), dateTimeFormatter);
					}

					List<String> authors = new ArrayList<String>();
					String tempAuthors = row.getCell(1).getStringCellValue();
					System.out.println(tempAuthors);

					authors.addAll(Arrays.asList(tempAuthors.split(",")));
					List<AuthorDto> authorDtos = new ArrayList<AuthorDto>();
					authorDtos = authors.stream().map(auth -> new AuthorDto(auth)).collect(Collectors.toList());

					BookDto tempBookDto = new BookDto();

					tempBookDto.setBookId((long) (row.getCell(5).getNumericCellValue()));
					tempBookDto.setBookTitle(row.getCell(0).getStringCellValue());
					tempBookDto.setAuthors(authorDtos);
					tempBookDto.setPublisher(new PublisherDto((row.getCell(3).getStringCellValue())));
					tempBookDto.setGenre(new GenreDto(row.getCell(10).getStringCellValue()));
					int pages = 0;
					if (!row.getCell(4).getStringCellValue().isEmpty()) {
						pages = Integer.valueOf(row.getCell(4).getStringCellValue());
						tempBookDto.setTotalPages(pages);
					}

					tempBookDto.setPublishDate(publisDate);
					tempBookDto.setTotalBookCount((int) row.getCell(11).getNumericCellValue());
					tempBookDto.setAvailableBookCount((int) row.getCell(11).getNumericCellValue());
					tempBookDto.setBookStatus(BookStatus.AVAILABLE);
					tempBookDto.setBookImageUrl(row.getCell(9).getStringCellValue());

					tempBookDto = addSingleBook(tempBookDto);

					bookDtos.add(tempBookDto);

				}
				i++;
			}

		} catch (IOException e) {
			throw new BookServiceException("file not valid");
		}

		finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return bookDtos;

	}

	@Override
	public List<UserDto> getAllOverDueBooks() throws BookServiceException {
		List<User> userList = new ArrayList<User>();
		List<IssueRecord> issueRecord = issueRecordRepository.findAll();
		LocalDate date = LocalDate.now();
		if (issueRecord != null) {
			for (IssueRecord issueRecord2 : issueRecord) {

				if (issueRecord2.getReturnDate().isBefore(date)
						&& issueRecord2.getTokenStatus().equals(TokenStatus.CONFIRM)) {

					userList.add(issueRecord2.getUser());
				}
			}
		} else {
			throw new NoOverDueRecordFound("no records available");
		}

		return userList.stream().map(temp -> util.convertUserEntityToDto(temp)).collect(Collectors.toList());

	}

	@Override
	public List<BookDateDto> getAllBooksByGenre(String genreName) throws BookServiceException {

		if (!(genreRepository.existsBygenreName(genreName)))
			throw new GenreNotFoundException("Genre not found");

		List<Book> bookList = new ArrayList<Book>();

		bookRepository.findAll().forEach(book -> {

			if (book.getGenre().getGenreName().equalsIgnoreCase(genreName))
				bookList.add(book);

		});
		
		List<BookDateDto> bookDateDto = new ArrayList<>();
		bookDateDto = bookList.stream().map(book -> util.convertBookEntityToBookDateDto(book))
				.collect(Collectors.toList());
		LocalDate availableDate = LocalDate.now().plusDays(10);

		for (BookDateDto books : bookDateDto) {
			if (books.getAvailableBookCount() == 0) {
				for (IssueRecord issue : issueRecordRepository.findAll()) {
					if (issue.getTokenStatus().equals(TokenStatus.CONFIRM)) {
						for (Book book : issue.getBooks()) {
							if (book.getBookTitle().equals(books.getBookTitle())) {
								if (availableDate.isAfter(issue.getReturnDate())) {
									books.setAvailableDate(issue.getReturnDate());
									availableDate = issue.getReturnDate();
								}
							}
						}
					}
				}
			} else {
				books.setAvailableDate(LocalDate.now());
			}
		}

		return bookDateDto;
	}

	/**
	 * @author M1056105
	 */
	@Override
	public List<BookDateDto> getAllBooksByBookName(String bookTitle) throws BookServiceException {

		List<BookDateDto> bookDateDto = new ArrayList<>();

		if (!(bookRepository.existsBybookTitle(bookTitle)))
			throw new BookNotFoundException("Book not found");

		List<Book> bookList = new ArrayList<Book>();

		bookRepository.findAll().forEach(book -> {

			if (book.getBookTitle().equalsIgnoreCase(bookTitle))
				bookList.add(book);

		});
		bookDateDto = bookList.stream().map(book -> modelMapper.map(book, BookDateDto.class))
				.collect(Collectors.toList());

		LocalDate availableDate = LocalDate.now().plusDays(10);

		for (BookDateDto books : bookDateDto) {
			if (books.getAvailableBookCount() == 0) {
				for (IssueRecord issue : issueRecordRepository.findAll()) {
					if (issue.getTokenStatus().equals(TokenStatus.CONFIRM)) {
						for (Book book : issue.getBooks()) {
							if (book.getBookTitle().equals(books.getBookTitle())) {
								if (availableDate.isAfter(issue.getReturnDate())) {
									books.setAvailableDate(issue.getReturnDate());
									availableDate = issue.getReturnDate();
								}
							}
						}
					}
				}
			} else {
				books.setAvailableDate(LocalDate.now());
			}
		}

		return bookDateDto;
	}

	/**
	 * @author M1056105
	 */
	@Override
	public List<BookDateDto> getAllBooksByPublisher(String publisherName) throws BookServiceException {

		List<BookDateDto> bookDateDto = new ArrayList<>();
		if (!(publisherRepository.existsBypublisherName(publisherName)))
			throw new PublisherNotFoundException("Publisher not found");

		List<Book> bookList = new ArrayList<Book>();

		bookRepository.findAll().forEach(book -> {

			if (book.getPublisher().getPublisherName().equalsIgnoreCase(publisherName))
				bookList.add(book);

		});

		bookDateDto = bookList.stream().map(book -> modelMapper.map(book, BookDateDto.class))
				.collect(Collectors.toList());
		LocalDate availableDate = LocalDate.now().plusDays(10);

		for (BookDateDto books : bookDateDto) {
			if (books.getAvailableBookCount() == 0) {
				for (IssueRecord issue : issueRecordRepository.findAll()) {
					if (issue.getTokenStatus().equals(TokenStatus.CONFIRM)) {
						for (Book book : issue.getBooks()) {
							if (book.getBookTitle().equals(books.getBookTitle())) {
								if (availableDate.isAfter(issue.getReturnDate())) {
									books.setAvailableDate(issue.getReturnDate());
									availableDate = issue.getReturnDate();
								}
							}
						}
					}
				}
			} else {
				books.setAvailableDate(LocalDate.now());
			}
		}

		return bookDateDto;
	}

	@Override
	public BookDto updateTheBook(BookDto bookDto, long bookId) throws BookServiceException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("Book Id is not present"));
		Book book2 = convertDtoToBookEntity(bookDto);

		if (book2.getBookTitle() != null) {
			book.setBookTitle(book2.getBookTitle());
		}
		if (book2.getTotalPages() != null)
			book.setTotalPages(book2.getTotalPages());
		if (book2.getPublishDate() != null)
			book.setPublishDate(book2.getPublishDate());
		if (book2.getBookStatus() != null)
			book.setBookStatus(book2.getBookStatus());
		if (book2.getBookImageUrl() != null)
			book.setBookImageUrl(book2.getBookImageUrl());
		if (book2.getTotalBookCount() != null)
			book.setTotalBookCount(book2.getTotalBookCount());
		if (book2.getAvailableBookCount() != null)
			book.setAvailableBookCount(book2.getAvailableBookCount());
		if (book2.getBookRating() != null)
			book.setBookRating(book2.getBookRating());
		if (book2.getAuthors() != null)
			book.setAuthors(book2.getAuthors());
		if (book2.getPublisher() != null)
			book.setPublisher(book2.getPublisher());
		if (book2.getGenre() != null)
			book.setGenre(book2.getGenre());
		if (book2.getFeedbacks() != null)
			book.setFeedbacks(book2.getFeedbacks());

		if (book != null) {

			bookRepository.saveAndFlush(book);
		}

		return util.convertBookEntityToDto(book);
	}

	@Override
	public BookDto getABook(long bookId) throws BookServiceException {
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("Book Id is not present"));
		return util.convertBookEntityToDto(book);
	}

}
