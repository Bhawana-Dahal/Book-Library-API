package components.booklibrary;

/**
 * Kernel methods interface for a queue of top books.
 */
public interface ImplementerInterface {

    /**
     * add a book.
     * 
     * @param x
     *            book to add.
     */
    void enqueue(Book x);

    /**
     * removes and returns highest rated book. highest rated book is at the
     * front, sorted alphabetically.
     * 
     * @return best book.
     */
    Book dequeue();

    /**
     * @return the size of the rep.
     */
    int length();
}
