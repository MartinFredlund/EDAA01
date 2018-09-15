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
		TreeSet<Book> set = new TreeSet<Book>();
		set.add(new Book("9113013645", "De två tornen", "Tolkien"));
		set.add(new Book("9113016482", "Hobbiten", "Tolkien"));
		System.out.println(set.contains(new Book("9113016482","", "")));
		System.out.println(set.contains(new Book("9113013645", "", "")));
		
		TreeMap<String, Book> tree = new TreeMap<String, Book>();
		tree.put ("9113013645", new Book("9113013645", "De två tornen", "Tolkien"));
		tree.put ("9113016482", new Book("9113016482", "Hobbiten", "Tolkien"));
		System.out.println(tree.get("9113016482"));
		System.out.println(tree.get("9113013645"));
	}
	
} 
