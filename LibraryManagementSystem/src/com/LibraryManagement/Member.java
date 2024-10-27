package com.LibraryManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Member {
	private Integer memberId;
	private String name;
	private String email;
	private List<Book> borrowedBooks = new ArrayList<Book>();
	
	public Member(Integer memberId, String name, String email) {
		setMemberId(memberId);
		setName(name);
		setEmail(email);
	}	
	
	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public Member(Integer memberId, String name) {
		this.memberId = memberId;
		this.name = name;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean borrow(Book b) {
		if(b.isAvailable()) {
			borrowedBooks.add(b);
			b.setAvailable(false);
			return true;
		}
		else {
			System.out.println("Sorry for inconvinience Book not available...");
			return false;
		}
	}
	
	public void returnBook(Book b) {
		borrowedBooks.remove(b);
		b.setAvailable(true);
		System.out.println("Successfully returned");
	}

	@Override
	public int hashCode() {
		return Objects.hash(memberId,name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return this.name.equals(other.name) && memberId == other.memberId;
	}
}
