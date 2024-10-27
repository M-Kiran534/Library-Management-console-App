package com.LibraryManagement;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Library {
	static Scanner s = new Scanner(System.in);
	private TreeSet<Book> books = new TreeSet<Book>();
	private HashSet<Member> members = new HashSet<Member>();

	public void start() {
		debug();
		System.out.println("WELLCOME TO THE ONLINE LIBRARY MANAGEMENT SYSTEM....♠♠♠");
		System.out.println("1.login\n2.signup\n3.Admistrator\n4.exit");
		while (s.hasNextInt()) {
			Integer input = s.nextInt();
			s.nextLine();
			switch (input) {
			case 1:
				logIn();
				System.out.println("Logout Successfull");
				break;
			case 2:
				createMember();
				break;
			case 3:
				System.out.println("would you like to add Book(y/n): ");
				while ((s.next().toLowerCase().charAt(0) == 'y')) {
					createBook();
				}
				showAll();
				break;
			case 4:
				System.out.println("Good bye pall...");
				return;
			default:
				System.out.println("wrong option please enter valid option...");
			}
			System.out.println("1.login\n2.signup\n3.Admistrator\n4.exit");
		}
	}

	private void createBook() {
		System.out.print("\nEnter BookID: ");
		Integer bookid = s.nextInt();
		s.nextLine();
		System.out.print("Enter Title of the Book: ");
		String title = s.next();
		System.out.print("\nEnter Author of the Book: ");
		String author = s.next();
		System.out.print("\nEnter Genre of the Book: ");
		String genre = s.next();
		System.out.print("\nWould you like to add '" + title + "' in library(Y/N): ");
		Boolean add = (s.next().toUpperCase().charAt(0) == 'Y') ? true : false;
		if (add) {
			addBook(new Book(bookid, title, author, genre));
			System.out.print("\nBook successfully added read to use");
		} else {
			System.out.print("\n---Book Not Added to library---");
		}
	}

	private void createMember() {
		System.out.print("Enter your MemberID: ");
		Integer memberId = s.nextInt();
		s.nextLine();
		System.out.print("Enter your Name: ");
		String name = s.next();
		System.out.print("Enter your EmailID: ");
		String email = s.next();
		System.out.print("\nWould you like to be a member in this library(Y/N): ");
		Boolean add = (s.next().toUpperCase().charAt(0) == 'Y') ? true : false;
		if (add) {
			registerMember(new Member(memberId, name, email));
			System.out.println("\n***Good to see you in our library feel free to come again***");
		} else {
			System.out.println("\n---Member was not added---");
		}
	}

	private void addBook(Book b) {
		books.add(b);
	}

	private void registerMember(Member m) {
		members.add(m);
	}

	private void logIn() {
		System.out.print("Please Enter your Membership Id: ");
		Integer id = s.nextInt();
		s.nextLine();
		System.out.print("Please Enter your name: ");
		String name = s.nextLine();
		Member user = userValid(id, name);
		Book b = null;
		if (user != null) {
			System.out.println("Hello.. " + user.getName());
			System.out.println("1.Find Book\n2.Borrow Book\n3.Books Taken\n4.Return Book\n5.Exit");
			while (s.hasNextInt()) {
				Integer input = s.nextInt();
				s.nextLine();
				switch (input) {
				case 1:
					System.out.println("Enter Title name of the book to find: ");
					String title = s.nextLine();
					b = findBook(title);
					if (b != null) {
						String status = b.isAvailable()? " In Stock":" not Available";
						System.out.println(title + " Book Found... and"+status);
					} else {
						System.out.println(title + " Book Not Found...");
					}
					break;
				case 2:
					if(user.borrow(b)) {
						System.out.println(b.getTitle()+" is added in your account... >> handel safe..♠");
					}
					else {
						System.out.println(b.getTitle()+" is not borrowed seems some issue please try again...");
					}
					break;
				case 3:
					System.out.println(user.getBorrowedBooks());
					break;
				case 4:
					System.out.println("Which Book would you like to return:");
					for(Object i : user.getBorrowedBooks()) {
						System.out.println(i);
					}
					System.out.print("Enter Book name to return to library:");
					String bName = s.nextLine();
					Book book = findBook(bName);
					if(user.getBorrowedBooks().contains(book)) {
						user.returnBook(book);
					}
					break;
				case 5:
					System.out.println("Signing off...");
					return;
				default:
					System.out.println("wrong option please enter valid option...");
				}
				System.out.println("1.Find Book\n2.Borrow Book\n3.Books Taken\n4.Return Book\n5.Exit");
			}
		} else {
			System.out.println("user name " + name + " not found..");
		}
	}

	public Book findBook(String title) {
		for (Book b : books) {
			if (b.getTitle().equalsIgnoreCase(title)) {
				return b;
			}
		}
		return null;
	}

	public Member userValid(Integer id, String name) {
		Iterator<Member> it = members.iterator();
		while (it.hasNext()) {
			Member m = it.next();
			if (m.hashCode() == new Member(id, name).hashCode()) {
				return m;
			}
		}
		return null;
	}

	public void showAll() {
		System.out.println(books);
		System.out.println(members);
	}

	private void debug() {
		members.add(new Member(1, "kiran", "kiran@gmail.com"));

		books.add(new Book(1, "the life", "AAA", "science", true));
		books.add(new Book(2, "the goat life", "BBB", "history", true));
		books.add(new Book(3, "the life of pie", "HHH", "science", false));
		books.add(new Book(4, "the bhahubali", "RRR", "history", true));
	}
}