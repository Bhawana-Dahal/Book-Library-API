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
    private final int maxR = 5;

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
        this.title = t;
        this.author = a;
        if (r < 0 || r > this.maxR) {
            throw new IllegalArgumentException(
                    "Rating must be between 0 and 5");
        }
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
}
