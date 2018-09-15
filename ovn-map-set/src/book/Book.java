package book;
import java.util.*;

public class Book { 
	private String isbn; 
	private String title; 
	private String author; 

	public Book(String isbn, String title, String author) { 
		this.isbn = isbn; 
		this.title = title; 
		this.author = author; 
	}
	
	public String toString() {
		return author + ", " + title;
	}
	
	public static void main(String[] args) {
		
	}
	
} 
