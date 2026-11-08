package components.booklibrary;

import components.sequence.Sequence;

/**
 * BookLibraryKernel. stores basic methods for the library
 */
public interface BookLibraryKernel {

    /**
     * adds a book to the library.
     *
     * @param x
     *            the book to add
     */
    void addBook(Book x);

    /**
     * removes a book from the library.
     *
     * @param x
     *            book to remove
     */
    void removeBook(Book x);

    /**
     * reports whether or not a book is on the shelf.
     * 
     * @param x
     *            the book its booking for.
     * @return if Book is there.
     */
    boolean hasBook(Book x);

    /**
     * returns a sperate sequence of all books given the rating.
     * 
     * @param rating
     *            an integer between 0-5.
     * @return a new sequence of books with said rating.
     */
    Sequence<Book> getBooksByRating(int rating);

    /**
     * @return the number of books in this.
     */
    int size();

    /**
     * clears teh shelf.
     */
    void clear();

}
