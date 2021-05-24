package com.mindtree.librarymanagementsystem.modules.book.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.mindtree.librarymanagementsystem.modules.book.dto.BookDateDto;
import com.mindtree.librarymanagementsystem.modules.book.dto.BookDto;
import com.mindtree.librarymanagementsystem.modules.book.exception.BookException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookNotFoundException;
import com.mindtree.librarymanagementsystem.modules.book.exception.service.BookServiceException;
import com.mindtree.librarymanagementsystem.modules.user.dto.UserDto;



/**
 * @author M1056118
 *
 */

public interface BookService {

	public List<BookDateDto> getAllBooksByAuthor(String authorName);

	/**
	 * @return List<BookDto>
	 */
	public List<BookDateDto> getAllBooks();

	/**
	 * @author M1056118
	 * @param bookDto
	 * @return BookDto
	 * @throws BookException 
	 */

	public BookDto addSingleBook(BookDto bookDto) throws BookServiceException;

	/**
	 * @return List<UserDto>
	 * @throws BookServiceException
	 */
	public List<UserDto> getAllOverDueBooks() throws BookServiceException;

	

	/**
	 * @param bookId
	 * @return String
	 * @throws BookServiceException
	 */
	String deleteBook(long bookId) throws BookServiceException;
	/**
	 * @param particularDate
	 * @return Set<BookDto>
	 * @throws BookServiceException
	 */
	Set<BookDto> getAllBooksShouldBeReturn(LocalDate particularDate) throws BookServiceException;


	/**
	 * @author M1056118
	 * @param file
	 * @return List<BookDto>
	 * @throws BookServiceException 
	 */
	public List<BookDto> saveAll(MultipartFile file) throws BookServiceException ;
	
	/**
	 * @param genreName
	 * @return bookDto 
	 * @author M1056105
	 * @throws BookServiceException
	 */
	public List<BookDateDto> getAllBooksByGenre(String genreName) throws BookServiceException;
	
	
	/**
	 * @param bookName
	 * @return bookDto
	 * @author M1056105
	 * @throws BookServiceException
	 */
	public List<BookDateDto> getAllBooksByBookName(String bookName) throws BookServiceException;
	
	/**
	 * @param publisherName
	 * @return bookDto
	 * @author M1056105
	 * @throws BookServiceException
	 */
	public List<BookDateDto> getAllBooksByPublisher(String publisherName) throws BookServiceException;

	/**
	 * @param bookDto
	 * @param bookId
	 * @return
	 *  @author M1056078
	 * @throws BookServiceException
	 */
	public BookDto updateTheBook(BookDto bookDto, long bookId) throws BookServiceException;

	public BookDto getABook(long bookId) throws  BookServiceException;

}
