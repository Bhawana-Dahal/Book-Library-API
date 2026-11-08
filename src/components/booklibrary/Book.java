package components.booklibrary;

/**
 * Book class where I make the book object.
 */
public class Book {
    /**
     * title of book.
     */
    private final String title;
    /**
     * author of book.
     */
    private final String author;
    /**
     * rating of book.
     */
    private final int rating;
    /**
     * max rating.
     */
    public static final int MAX_RATING = 5;

    /**
     * full constructor.
     *
     * @param t
     *            title
     * @param a
     *            author
     * @param r
     *            rating
     */
    public Book(String t, String a, int r) {
        if (t == null || a == null) {
            throw new IllegalArgumentException("Must include title and author");
        }
        if (r < 0 || r > MAX_RATING) {
            throw new IllegalArgumentException(
                    "Rating must be between 0 and 5");
        }
        this.title = t;
        this.author = a;
        this.rating = r;
    }

    /**
     * gives you the book title.
     *
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * gives you the book author.
     *
     * @return author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * gives you the book rating.
     *
     * @return rating.
     */
    public int getRating() {
        return this.rating;
    }

    //no setters.
    // users changing things could mess up the shelves.

    /**
     * checks for doubles.
     * 
     * @param other
     *            is other book.
     * @return whether 2 books are the same.
     */
    public boolean isSameBook(Book other) {
        return this.title.equalsIgnoreCase(other.title)
                && this.author.equalsIgnoreCase(other.author);
    }

    /**
     * ex: The Hunger Games By Suzanne Collins (5/5).
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.title + " by " + this.author + " (" + this.rating + "/"
                + MAX_RATING + ")";
    }
}
