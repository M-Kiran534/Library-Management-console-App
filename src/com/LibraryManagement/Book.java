package com.LibraryManagement;

public class Book implements Comparable<Book>{
	private Integer bookId;
	private String title;
	private String author;
	private String genre;
	private Boolean isAvailable;

	public Book(Integer bookId, String title, String author, String genre) {
		setBookId(bookId);
		setAuthor(author);
		setTitle(title);
		setGenre(genre);
	}
	
	public Book(Integer bookId, String title, String author, String genre, boolean isAvailable) {
		this(bookId,title,author,genre);
		setAvailable(isAvailable);
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void borrowBook() {
		setAvailable(false);
	}

	public void returnBook() {
		setAvailable(true);
	}
	
	public String showDetails() {
		return "BookId=" + this.bookId + "\ntitle=" + this.title + "\nauthor=" + this.author + 
				"\ngenre=" + this.genre + "\n" + this.isAvailable + "\n";
	}

	@Override
	public String toString() {
		return "ID: "+this.bookId+"Title: "+this.title+"\n";
	}

	@Override
	public int compareTo(Book otherBook) {
		// Compare by bookId, title, author, or any other field
		return this.bookId.compareTo(otherBook.bookId); // Compare by bookId
	}

}
