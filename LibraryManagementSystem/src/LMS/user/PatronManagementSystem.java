package LMS.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import LMS.book.Book;

public class PatronManagementSystem {
	List<Patron> patronsList;

	public PatronManagementSystem() {
		patronsList = new ArrayList<>();
	}

	public List<Patron> getPatronsList() {
		return patronsList;
	}

	public void setPatronsList(List<Patron> patronsList) {
		this.patronsList = patronsList;
	}

	public void addPatron(Patron patron) {
		this.patronsList.add(patron);
		System.out.println("Added patron : " + patron.getName() + " successfully");
	}

	public void updatePatron(String id, Patron updatedPatron) {
		if (Objects.isNull(id) || id.isEmpty()) {
			System.out.println("Insufficient details provided to update the Patron");
			return;
		}

		for (Patron patron : this.patronsList) {
			if (id.equalsIgnoreCase(patron.getId())) {
				this.patronsList.remove(patron);
				this.patronsList.add(updatedPatron);
				System.out.println("Updated patron : " + patron.getName() + " successfully");
				return;
			}
		}
	}

	public void displayPatronDetails(Patron patron) {
		patron.displayPatronDetails();
	}

	public void borrowBook(Patron patron, Book book) {
		patron.borrowBook(book);
	}

	public void returnBook(Patron patron, Book book) {
		patron.returnBook(book);
	}

	public Patron findPatronById(String id) {
		for (Patron patron : this.getPatronsList())
			if (id.equalsIgnoreCase(patron.getId()))
				return patron;

		return null;
	}
}
