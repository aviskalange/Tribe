import java.util.List;

import LMS.LibraryManagementSystem;
import LMS.book.Book;
import LMS.user.Patron;

public class Main {
	public static void main(String[] args) {
		LibraryManagementSystem libraryManagementSystem = new LibraryManagementSystem();

		// Create books
		Book book1 = new Book("B1", "Effective Java", "Joshua Bloch", "2018");
		Book book2 = new Book("B2", "Clean Code", "Robert C. Martin", "2008");
		Book book3 = new Book("B3", "The Pragmatic Programmer", "Andrew Hunt", "1999");
		Book book4 = new Book("B4", "Head First Design Patterns", "Eric Freeman", "2004");

		// Create Patrons
		Patron patron1 = new Patron("P1", "John Doe", "555-1234");
		Patron patron2 = new Patron("P2", "Jane Smith", "555-5678");
		Patron patron3 = new Patron("P3", "Alice Johnson", "555-8765");
		Patron patron4 = new Patron("P4", "Bob Williams", "555-4321");

		// Add Books to the system
		libraryManagementSystem.addBook(book1);
		libraryManagementSystem.addBook(book2);
		libraryManagementSystem.addBook(book3);
		libraryManagementSystem.addBook(book4);

		System.out.println("-------------------------------------------");

		// Add Patrons to the system
		libraryManagementSystem.addPatron(patron1);
		libraryManagementSystem.addPatron(patron2);
		libraryManagementSystem.addPatron(patron3);
		libraryManagementSystem.addPatron(patron4);

		System.out.println("-------------------------------------------");

		// Update book and patron
		book2.setTitle("Design Clean Code");
		libraryManagementSystem.updateBook("B2", book2);

		patron3.setName("Alice D. Johnson");
		libraryManagementSystem.updatePatron("P3", patron3);

		displayAvailableAndBorrowedBooks(libraryManagementSystem);

		// Borrow books
		libraryManagementSystem.borrowBook(patron1, book1);
		libraryManagementSystem.borrowBook(patron3, book4);
		displayAvailableAndBorrowedBooks(libraryManagementSystem);

		// Return book
		libraryManagementSystem.returnBook(patron1, book1);
		displayAvailableAndBorrowedBooks(libraryManagementSystem);
	}

	private static void displayAvailableAndBorrowedBooks(LibraryManagementSystem libraryManagementSystem) {
		System.out.println("-------------------------------------------");

		// Display details of available books
		System.out.println("---------Available Books------------");
		List<Book> availableBooks = libraryManagementSystem.getAvailableBooks();
		for (Book book : availableBooks)
			book.displayBookDetails();

		// Display details of borrowed books
		System.out.println("---------Borrowed Books-------------");
		List<Book> borrowedBooks = libraryManagementSystem.getBorrowedBooks();
		for (Book book : borrowedBooks)
			book.displayBookDetails();

		System.out.println("-------------------------------------------");
	}
}