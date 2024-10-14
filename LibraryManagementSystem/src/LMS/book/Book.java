package LMS.book;

public class Book {
	private String isbn;

	private String title;

	private String author;

	private String publicationYear;

	private boolean isAvailable;

	public Book(String isbn, String title, String author, String publicationYear) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isAvailable = true;
		this.displayBookDetails();
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean available) {
		isAvailable = available;
	}

	public void displayBookDetails() {
		System.out.println("-------------------------------------------");
		System.out.println("ISBN              " + this.isbn);
		System.out.println("Title             " + this.title);
		System.out.println("Author            " + this.author);
		System.out.println("Publication Year  " + this.publicationYear);
		System.out.println("-------------------------------------------");
	}
}
