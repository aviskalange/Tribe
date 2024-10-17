package LMS;

import java.util.List;

import LMS.book.Book;
import LMS.book.BookManagementSystem;
import LMS.user.Patron;
import LMS.user.PatronManagementSystem;

public class LibraryManagementSystem {
	private final PatronManagementSystem patronManagementSystem = new PatronManagementSystem();

	private final BookManagementSystem bookManagementSystem = new BookManagementSystem();

	public void borrowBook(Patron patron, Book book) {
		book = this.bookManagementSystem.findBookByIsbn(book.getIsbn());
		if (!book.isAvailable()) {
			System.out.println("Book : " + book.getTitle() + " is not available.");
			return;
		}

		book.setAvailable(false);
		this.patronManagementSystem.borrowBook(patron, book);
		this.bookManagementSystem.makeBookUnavailable(book);
		System.out.println("Book : " + book.getTitle() + " borrowed successfully for Patron : " + patron.getName());
	}

	public void returnBook(Patron patron, Book book) {
		patron = this.patronManagementSystem.findPatronById(patron.getId());
		if (!patron.getBorrowedBooks().contains(book)) {
			System.out.println("Book : " + book.getTitle() + " not borrowed by Patron : " + patron.getName());
			return;
		}

		book.setAvailable(true);
		this.patronManagementSystem.returnBook(patron, book);
		this.bookManagementSystem.makeBookAvailable(book);
		System.out.println("Book : " + book.getTitle() + " returned successfully for Patron : " + patron.getName());
	}

	public void addBook(Book book) {
		this.bookManagementSystem.addBook(book);
	}

	public void updateBook(String isbn, Book book) {
		this.bookManagementSystem.updateBook(isbn, book);
	}

	public void removeBook(String isbn) {
		this.bookManagementSystem.removeBook(isbn);
	}

	public void addPatron(Patron patron) {
		this.patronManagementSystem.addPatron(patron);
	}

	public void updatePatron(String id, Patron updatedPatron) {
		this.patronManagementSystem.updatePatron(id, updatedPatron);
	}

	public List<Book> getAvailableBooks() {
		return this.bookManagementSystem.getAvailableBooks();
	}

	public List<Book> getBorrowedBooks() {
		return this.bookManagementSystem.getBorrowedBooks();
	}
}
