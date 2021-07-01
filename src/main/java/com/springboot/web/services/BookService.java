package com.springboot.web.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.web.entities.Books;
@Component
public class BookService {
	
	private static List<Books> list = new ArrayList<>();
	
	static {
		list.add(new Books(12, "java refrences", "xyz"));
		list.add(new Books(13, "Python refrences", "abc"));
		list.add(new Books(14, "c++ refrences", "atz"));
		list.add(new Books(15, "Ruby refrences", "hyt"));
	}
	
	//get all books 
	public List<Books> getallBooks(){
		return list;
	}
	
	//get single book by id 
	public Books getBookById(int id) {
		Books book = null;
		try {
			list.stream().filter(e-> e.getId()== id).findFirst().get();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return book;
		
	}
	
	public Books addBook(Books b) {
		list.add(b);
		return b;
		
	}
	
	public void deleteBooks(int bid) {
		list=list.stream().filter(book ->{
			if(book.getId()!=bid) {
				return true;
			}else {
				return false;
			}
		}).collect(Collectors.toList());
		
		
		
	}
	
	public void updateBook(Books book, int bid ) {
	list = 	list.stream().map(b->{
			if(b.getId()==bid) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		
	}
	

}

