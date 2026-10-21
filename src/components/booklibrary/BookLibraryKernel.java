package components.booklibrary;

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
     * returns the size of the library.
     *
     * @return the size of the library
     */
    int size();

    /**
     * clears teh shelf.
     */
    void clear();

}
