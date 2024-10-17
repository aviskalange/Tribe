package LMS.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BookManagementSystem {
	private List<Book> allBooks;

	private List<Book> availableBooks;

	private List<Book> borrowedBooks;

	public BookManagementSystem() {
		this.allBooks = new ArrayList<>();
		this.availableBooks = new ArrayList<>();
		this.borrowedBooks = new ArrayList<>();
	}

	public List<Book> getAllBooks() {
		return allBooks;
	}

	public void setAllBooks(List<Book> allBooks) {
		this.allBooks = allBooks;
	}

	public List<Book> getAvailableBooks() {
		return availableBooks;
	}

	public void setAvailableBooks(List<Book> availableBooks) {
		this.availableBooks = availableBooks;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public void addBook(Book book) {
		this.allBooks.add(book);
		this.availableBooks.add(book);
		System.out.println("Added book : " + book.getTitle() + " successfully");
		book.displayBookDetails();
	}

	public void removeBook(String isbn) {
		for (Book book : this.allBooks) {
			if (isbn.equalsIgnoreCase(book.getIsbn())) {
				this.allBooks.remove(book);
				this.availableBooks.remove(book);
				System.out.println("Removed book : " + book.getTitle() + " successfully");
				return;
			}
		}
	}

	public void updateBook(String isbn, Book updatedBook) {
		if (Objects.isNull(isbn) || isbn.isEmpty()) {
			System.out.println("Insufficient details provided to update the Book");
			return;
		}
		Book book = this.findBookByIsbn(isbn);

		if (Objects.isNull(book)) {
			System.out.println("Book with isbn : " + isbn + " not found");
			return;
		}
		this.allBooks.remove(book);
		this.allBooks.add(updatedBook);

		this.availableBooks.remove(book);
		this.availableBooks.add(updatedBook);
		System.out.println("Updated book : " + book.getTitle() + " successfully");
		book.displayBookDetails();
	}

	public Book findBookByIsbn(String isbn) {
		if (Objects.isNull(isbn) || isbn.isEmpty()) {
			System.out.println("Insufficient details provided to find the Book");
			return null;
		}

		for (Book book : this.allBooks) {
			if (isbn.equalsIgnoreCase(book.getIsbn())) {
				return book;
			}
		}

		System.out.println("Book with isbn : " + isbn + " not found");
		return null;
	}

	public Book findBookByTitle(String title) {
		if (Objects.isNull(title) || title.isEmpty()) {
			System.out.println("Insufficient details provided to find the Book");
			return null;
		}

		for (Book book : this.allBooks) {
			if (title.equalsIgnoreCase(book.getTitle())) {
				return book;
			}
		}

		System.out.println("Book with title : " + title + " not found");
		return null;
	}

	public Book findBookByAuthor(String author) {
		if (Objects.isNull(author) || author.isEmpty()) {
			System.out.println("Insufficient details provided to find the Book");
			return null;
		}

		for (Book book : this.allBooks) {
			if (author.equalsIgnoreCase(book.getAuthor())) {
				return book;
			}
		}

		System.out.println("Book with author : " + author + " not found");
		return null;
	}

	public void makeBookUnavailable(Book book) {
		this.availableBooks.remove(book);
		this.borrowedBooks.add(book);
	}

	public void makeBookAvailable(Book book) {
		this.availableBooks.add(book);
		this.borrowedBooks.remove(book);
	}
}
