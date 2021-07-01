package com.springboot.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.web.entities.Books;
import com.springboot.web.entities.User;
import com.springboot.web.repositiory.UserRepo;
import com.springboot.web.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookervice;
	
	// get all books
	@RequestMapping(value = "/books" , method = RequestMethod.GET)
	@ResponseBody

	public ResponseEntity<List<Books>> getBoooks() {
		List<Books> list =bookervice.getallBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		/*
		 * int a= 6; int b = 6 ; int c = 10; int d = 40; Books books = new Books();
		 * books.setId(1); books.setAuthor("Ramesh Nautiyal");
		 * books.setTitle("History of Nehru");
		 */
		
		return ResponseEntity.of(Optional.of(list));
	}
	// get  book from id 
	@GetMapping(value = "/books/{id}" )
	public ResponseEntity<Books> getBooks(@PathVariable("id") int id) {
		//System.out.println(id);
		Books book =  bookervice.getBookById(id); 
		if(book== null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		System.out.println(book);
		return ResponseEntity.of(Optional.of(book));
		
				
	}
	
	
	//  add books
	@PostMapping(value = "/books")
	public ResponseEntity<Books> addBooks(@RequestBody Books book) {
		Books b=null;	
	try {
		b = 	this.bookervice.addBook(book);
		System.out.println(book);
			return ResponseEntity.of(Optional.of(b));
	}catch(Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
		
		
	}
	
	// delete all  books  
	@DeleteMapping(value = "/books/{bookid}")
	public ResponseEntity<Void> deleteBook(@PathVariable ("bookid") int bookid) {
		try {
			this.bookervice.deleteBooks(bookid);
			System.out.println(bookid);
			return ResponseEntity.ok().build();
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		
	}
	
	
	// update book
	@PutMapping(value = "/books/{bookID}")
	public Books updateBooks(@RequestBody Books book, @PathVariable ("bookID") int bookID) {
		
		 this.bookervice.updateBook(book, bookID);
		 return book;
	}
	

}
