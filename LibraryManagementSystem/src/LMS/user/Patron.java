package LMS.user;

import java.util.ArrayList;
import java.util.List;

import LMS.book.Book;

public class Patron extends User{
	private List<Book> borrowingHistory;

	private List<Book> borrowedBooks;

	public Patron(String id, String name, String phoneNumber) {
		super(id, name, phoneNumber);
		this.borrowingHistory = new ArrayList<>();
		this.borrowedBooks = new ArrayList<>();
	}

	public List<Book> getBorrowingHistory() {
		return borrowingHistory;
	}

	public void setBorrowingHistory(List<Book> borrowingHistory) {
		this.borrowingHistory = borrowingHistory;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public void displayPatronDetails() {
		System.out.println("-------------------------------------------");
		System.out.println("ID              " + this.id);
		System.out.println("Name            " + this.name);
		System.out.println("Phone number    " + this.phoneNumber);
		System.out.println("-------------------------------------------");
	}

	public void borrowBook(Book book) {
		this.borrowingHistory.add(book);
		this.borrowedBooks.add(book);
	}

	public void returnBook(Book book) {
		this.borrowedBooks.remove(book);
	}
}
