
package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a book in the library lending system.
 * Stores book details and manages borrowing availability.
 *
 * @author Jillian Drake
 */
public class Book {

    private String isbn;
    private String title;
    private String author;
    private boolean available;

    /**
     * Creates a new book that is initially available.
     *
     * @param isbn the book's ISBN
     * @param title the book's title
     * @param author the book's author
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    /**
     * Returns the ISBN.
     *
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Returns the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Checks whether the book is available.
     *
     * @return true if available, otherwise false
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Borrows the book if it is available.
     *
     * @throws IllegalStateException if already borrowed
     */
    public void borrowBook() {
        if (!available) {
            throw new IllegalStateException("Book is already borrowed.");
        }
        available = false;
    }

    /**
     * Returns the book if it is currently borrowed.
     *
     * @throws IllegalStateException if already available
     */
    public void returnBook() {
        if (available) {
            throw new IllegalStateException("Book is already available.");
        }
        available = true;
    }

    /**
     * Returns the book's details and availability.
     *
     * @return formatted book information
     */
    @Override
    public String toString() {
        String status = available ? "AVAILABLE" : "BORROWED";
        return isbn + " " + title + " by " + author + " [" + status + "]";
    }
}