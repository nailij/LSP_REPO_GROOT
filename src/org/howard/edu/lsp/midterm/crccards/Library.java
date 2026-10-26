
package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a library that stores books and manages lending.
 * Enforces a maximum of three borrowed books at one time.
 *
 * @author Jillian Drake
 */
public class Library {

    private Map<String, Book> books;
    private int borrowedCount;

    /**
     * Creates an empty library.
     */
    public Library() {
        books = new HashMap<>();
        borrowedCount = 0;
    }

    /**
     * Adds a book to the library.
     *
     * @param book the book to add
     * @throws IllegalArgumentException if the ISBN already exists
     */
    public void addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Duplicate ISBN.");
        }
        books.put(book.getIsbn(), book);
    }

    /**
     * Finds a book by ISBN.
     *
     * @param isbn the ISBN to search for
     * @return the matching book or null if not found
     */
    public Book findBook(String isbn) {
        return books.get(isbn);
    }

    /**
     * Borrows a book if it exists and the limit has not been reached.
     *
     * @param isbn the ISBN of the book
     * @throws IllegalArgumentException if the book does not exist
     * @throws IllegalStateException if the book is already borrowed
     *         or the borrowing limit has been reached
     */
    public void borrowBook(String isbn) {
        Book book = findBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        if (borrowedCount >= 3) {
            throw new IllegalStateException("Borrowing limit reached.");
        }

        book.borrowBook();
        borrowedCount++;
    }

    /**
     * Returns a borrowed book to the library.
     *
     * @param isbn the ISBN of the book
     * @throws IllegalArgumentException if the book does not exist
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook(String isbn) {
        Book book = findBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        book.returnBook();
        borrowedCount--;
    }

    /**
     * Retrieves all currently available books.
     *
     * @return a list of available books
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    /**
     * Retrieves books by an exact, case-sensitive author match.
     *
     * @param author the author to search for
     * @return a list of matching books
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> matchingBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    /**
     * Retrieves all books sorted by ISBN.
     *
     * @return a list sorted in ascending ISBN order
     */
    public List<Book> getBooksSortedByIsbn() {
        List<Book> sortedBooks = new ArrayList<>(books.values());
        sortedBooks.sort(Comparator.comparing(Book::getIsbn));
        return sortedBooks;
    }

    /**
     * Returns the number of currently borrowed books.
     *
     * @return the borrowed book count
     */
    public int getBorrowedBookCount() {
        return borrowedCount;
    }
}