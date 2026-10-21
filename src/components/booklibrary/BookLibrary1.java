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
     * creates a new representation.
     */
    public BookLibrary1() {
        this.rep = new Map1L<>();
    }

    /**
     * max rating.
     */
    private final int maxR = 5;

    /**
     * gives the size of the shelf. ratings go from 0-5.
     *
     * @return number of books on shelf.
     */
    @Override
    public int size() {
        int total = 0;
        for (int rating = 0; rating <= this.maxR; rating++) {
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
            String title = x.getTitle();
            if (this.rep.hasKey(rating)) {
                Sequence<Book> books = this.rep.value(rating);
                int i = 0;
                while (i < books.length() && title
                        .compareToIgnoreCase(books.entry(i).getTitle()) > 0) {
                    i++;
                }
                books.add(i, x);
            } else {
                Sequence<Book> books = new Sequence1L<Book>();
                books.add(0, x);
                this.rep.add(rating, books);
            }
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
        int rating = x.getRating();
        if (this.rep.hasKey(rating)) {
            Sequence<Book> books = this.rep.value(rating);
            String title = x.getTitle();
            String author = x.getAuthor();
            int i = 0;
            while (i < books.length() && (title
                    .compareToIgnoreCase(books.entry(i).getTitle()) != 0
                    || author.compareToIgnoreCase(
                            books.entry(i).getAuthor()) != 0)) {
                i++;
            }
            books.remove(i);
        } else {
            throw new IllegalArgumentException("Book does not exist");
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
        if (rating < 0 || rating > this.maxR) {
            throw new IllegalArgumentException(
                    "Rating must be between 0 and 5");
        }
        Sequence<Book> result = new Sequence1L<>();
        if (this.rep.hasKey(rating)) {
            Sequence<Book> books = this.rep.value(rating);
            int i = 0;
            while (i < books.length()) {
                result.add(i, books.entry(i));
                i++;
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
        for (int rating = 0; rating <= this.maxR; rating++) {
            if (this.rep.hasKey(rating)) {
                Sequence<Book> books = this.rep.value(rating);

                int i = 0;
                while (i < books.length() && (x.getTitle()
                        .compareToIgnoreCase(books.entry(i).getTitle()) != 0
                        || x.getAuthor().compareToIgnoreCase(
                                books.entry(i).getAuthor()) != 0)) {
                    i++;
                }

                if (i < books.length()) {
                    return true;
                }
            }
        }

        return false;

    }
}
