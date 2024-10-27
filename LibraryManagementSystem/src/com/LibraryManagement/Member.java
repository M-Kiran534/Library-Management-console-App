package com.LibraryManagement;

import java.util.ArrayList;
import java.util.Objects;

public class Member {
	private Integer memberId;
	private String name;
	private String email;
	private ArrayList<Book> borrowedBooks;
	
	public Member(Integer memberId, String name, String email) {
		setMemberId(memberId);
		setName(name);
		setEmail(email);
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

	public void borrow(Book b) {
		if(b.isAvailable()) {
			borrowedBooks.add(b);
		}
		else {
			System.out.println("Sorry for inconvinience Book not available...");
		}
	}
	
	public void returnBook(Book b) {
		borrowedBooks.remove(b);
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
