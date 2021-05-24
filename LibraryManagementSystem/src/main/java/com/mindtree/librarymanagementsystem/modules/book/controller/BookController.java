package com.mindtree.librarymanagementsystem.modules.book.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mindtree.librarymanagementsystem.modules.book.dto.BookDateDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
import com.mindtree.librarymanagementsystem.modules.book.exception.BookException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
import com.mindtree.librarymanagementsystem.modules.book.service.BookService;
import com.mindtree.librarymanagementsystem.modules.common.apiconfig.ApiResponse;
import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;

@RestController
@RequestMapping("/api/book")
@CrossOrigin("*")
public class BookController {

	@Autowired
	private BookService bookService;

	private ApiResponse apiResponse = new ApiResponse();

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/insert")
	public ResponseEntity<ApiResponse> addSingleBook(@Valid @RequestBody BookDto bookDto)
			throws MethodArgumentNotValidException, BookServiceException {

		bookDto = bookService.addSingleBook(bookDto);
		apiResponse.setBody(bookDto);
		apiResponse.setMessage("Book Added Successfully");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.CREATED);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@PutMapping("/{bookId}")
	public ResponseEntity<ApiResponse> updateBookDetails(@RequestBody BookDto bookDto, @PathVariable long bookId)
			throws BookServiceException {

		bookDto = bookService.updateTheBook(bookDto, bookId);
		apiResponse.setBody(bookDto);
		apiResponse.setMessage("Book Added Successfully");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.CREATED);
		apiResponse.setStatus(HttpStatus.FOUND);

		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/{bookId}")
	public ResponseEntity<ApiResponse> retrieveBook(@PathVariable long bookId) throws BookServiceException {
		BookDto bookDto = bookService.getABook(bookId);
		apiResponse.setBody(bookDto);
		apiResponse.setMessage("Searched Book By bookid Successfull");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/books")
	public ResponseEntity<ApiResponse> retrieveBooks() {
		List<BookDateDto> listBook = bookService.getAllBooks();
		apiResponse.setBody(listBook);
		apiResponse.setMessage("Search Successfull");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/author/{authorName}")
	public ResponseEntity<ApiResponse> fetchBooksByAuthor(@PathVariable String authorName) {
		List<BookDateDto> listBook = bookService.getAllBooksByAuthor(authorName);
		apiResponse.setBody(listBook);
		apiResponse.setMessage("Searched Book By Author Successfull");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/genre/{genreName}")
	public ResponseEntity<ApiResponse> fetchBooksByGenre(@PathVariable String genreName) throws BookException {
		List<BookDateDto> listBook = bookService.getAllBooksByGenre(genreName);
		apiResponse.setBody(listBook);
		apiResponse.setMessage("Searched Book By Category Successfull");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/name/{bookName}")
	public ResponseEntity<ApiResponse> fetchBookByName(@PathVariable String bookName) throws BookException {
		List<BookDateDto> listBook = bookService.getAllBooksByBookName(bookName);
		apiResponse.setBody(listBook);
		apiResponse.setMessage("Searched Book By BookName Successfull");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	@GetMapping("/publisher/{publisherName}")
	public ResponseEntity<ApiResponse> fetchBooksByPublisher(@PathVariable String publisherName) throws BookException {
		List<BookDateDto> listBook = bookService.getAllBooksByPublisher(publisherName);
		apiResponse.setBody(listBook);
		apiResponse.setMessage("Searched Book By Publisher Successfull");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/overdues")
	public ResponseEntity<ApiResponse> getAllOverDueBooks() throws BookServiceException {
		List<UserDto> listBook = bookService.getAllOverDueBooks();
		apiResponse.setBody(listBook);
		apiResponse.setMessage("Search Successfull");
		apiResponse.setError(false);
		apiResponse.setStatus(HttpStatus.FOUND);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/batch-upload")
	public ResponseEntity<ApiResponse> addAllBooks(@RequestParam("file") MultipartFile file)
			throws BookServiceException {
		if (!file.isEmpty()) {
			apiResponse.setBody(bookService.saveAll(file));
			apiResponse.setError(false);
			apiResponse.setMessage("Success");
			apiResponse.setStatus(HttpStatus.CREATED);
		}
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	// shows books to be returned on particular date

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/return-status/date")
	public ResponseEntity<ApiResponse> getBook(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate particularDate)
			throws BookException {
		Set<BookDto> bookDto = bookService.getAllBooksShouldBeReturn(particularDate);
		apiResponse.setBody(bookDto);
		apiResponse.setMessage("Books to be returned");
		apiResponse.setError(false);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	// show books to be returned today
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/return-status/today")
	public ResponseEntity<ApiResponse> getBook() throws BookException {
		apiResponse.setBody(bookService.getAllBooksShouldBeReturn(LocalDate.now()));
		apiResponse.setMessage("Books to be returned");
		apiResponse.setError(false);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{bookId}")
	public ResponseEntity<ApiResponse> addBook(@PathVariable long bookId) throws BookException {
		apiResponse.setBody(bookService.deleteBook(bookId));
		apiResponse.setMessage("Book deleted Successfully");
		apiResponse.setError(false);
		return ResponseEntity.status(HttpStatus.OK).body(apiResponse);

	}

}
