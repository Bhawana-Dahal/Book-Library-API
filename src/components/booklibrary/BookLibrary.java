package components.booklibrary;

import components.sequence.Sequence;

/**
 * Regular methods interface.
 */
public interface BookLibrary extends BookLibraryKernel {

    /**
     * returns whether or not this book is on the shelf.
     *
     * @param x
     *            is the book is question.
     * @return if shelf has book x.
     */
    boolean hasBook(Book x);

    /**
     * returns whether or not shelf is empty.
     *
     * @return if shelf is empty.
     */
    boolean isEmpty();

    /**
     * returns all books with same rating.
     *
     * @param rating
     *            is the value you rated the book (0-5).
     * @return a seperate series of books with a shared rating.
     */
    Sequence<Book> getBooksByRating(int rating);
}
