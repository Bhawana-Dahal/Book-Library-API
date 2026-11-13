package components.booklibrary;

import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * where the kernel methods will get implimented. BookLibrary1
 */
public class BookLibrary1 extends BookLibrarySecondary {
    /**
     * the representation.
     */
    private Map<Integer, Sequence<Book>> rep;

    /**
     * @param shelf
     *            the shelf to search.
     * @param x
     *            the book we're booking for.
     * @return the index of the same book in shelf. It will return -1 if no such
     *         book exists.
     */
    private static int indexOf(Sequence<Book> shelf, Book x) {
        int i = 0;
        while (i < shelf.length() && !x.equals(shelf.entry(i))) {
            i++;
        }
        return i < shelf.length() ? i : -1;
        //if else?
        //return i if on shelf, -1 if not. This could also be invalid syntax.
    }

    /**
     * finds which shelf holds same book as x. finds x at any rating.
     *
     * @param x
     *            the book to look for.
     * @return the rating of the book. -1 is not found.
     */
    private int findRating(Book x) {
        int found = -1;
        int r = 0;
        while (found < 0 && r <= Book.MAX_RATING) {
            if (this.rep.hasKey(r) && indexOf(this.rep.value(r), x) >= 0) {
                found = r;
            }
            r++;
        }
        return found;
    }

    /**
     * creates a new representation.
     */
    public BookLibrary1() {
        this.rep = new Map1L<>();
    }

    /**
     * gives the size of the shelf. ratings go from 0-5.
     *
     * @return number of books on shelf.
     */
    @Override
    public int size() {
        int total = 0;
        for (int rating = 0; rating <= Book.MAX_RATING; rating++) {
            if (this.rep.hasKey(rating)) {
                total += this.rep.value(rating).length();
            }
        }
        return total;
    }

    /**
     * clears the representation.
     */
    @Override
    public void clear() {
        this.rep = new Map1L<>();
    }

    /**
     * adds books to the rep.
     *
     * @requires a paramter x
     * @param x
     *            is the book to be added.
     * @ensures the book is added.
     */
    @Override
    public void addBook(Book x) {
        if (this.hasBook(x)) {
            throw new IllegalArgumentException("Book already exists");
        } else {
            int rating = x.getRating();
            if (!this.rep.hasKey(rating)) {
                this.rep.add(rating, new Sequence1L<Book>());
            }
            Sequence<Book> shelf = this.rep.value(rating);
            // sort.
            int i = 0;
            while (i < shelf.length() && x.getTitle()
                    .compareToIgnoreCase(shelf.entry(i).getTitle()) > 0) {
                i++;
            }
            shelf.add(i, x);
        }
    }

    /**
     * Removes a book.
     *
     * @param x
     *            book to be removed
     * @requires a parameter called x.
     * @ensures x is removed from the shelf.
     */
    @Override
    public void removeBook(Book x) {
        int rating = this.findRating(x);
        if (rating < 0) {
            throw new IllegalArgumentException("Book does not exist");
        } else {
            Sequence<Book> shelf = this.rep.value(rating);
            shelf.remove(indexOf(shelf, x));
            if (shelf.length() == 0) {
                this.rep.remove(rating); //no empties.
            }
        }
    }

    /**
     * Returns a sequence of books that share a rating.
     *
     * @param rating
     *            the rating to search for
     * @return a separate sequence of books with the specified rating
     * @throws IllegalArgumentException
     *             if rating is outside the range 0 to MAX_RATING
     */
    @Override
    public Sequence<Book> getBooksByRating(int rating) {
        if (rating < 0 || rating > Book.MAX_RATING) {
            throw new IllegalArgumentException(
                    "Rating must be between 0 and 5");
        }
        Sequence<Book> result = new Sequence1L<>();
        if (this.rep.hasKey(rating)) {
            Sequence<Book> shelf = this.rep.value(rating);
            for (int i = 0; i < shelf.length(); i++) {
                result.add(i, shelf.entry(i));
            }
        }
        return result;
    }

    /**
     * reports back whether or not the library has this book.
     *
     * @param x
     *            the book in question.
     * @return if book is on the shelf.
     * @ensures whether or not the book is there.
     */
    @Override
    public boolean hasBook(Book x) {
        return this.findRating(x) >= 0;
    }
}
