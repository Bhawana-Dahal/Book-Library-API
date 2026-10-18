package components.booklibrary;

/**
 * Book class where I make the book object.
 */
public class Book {

    private String title;
    private String author;
    private int rating;

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
        this.setRating(r);
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
     * sets this.title to title.
     * 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
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
     * sets this.author to author.
     * 
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * gives you the book rating.
     * 
     * @return rating.
     */
    public int getRating() {
        return this.rating;
    }

    /**
     * sets this.rating to rating. ratings must be between 0-5
     * 
     * @param rating
     */

    public void setRating(int rating) {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 0-5");
        }
        this.rating = rating;
    }
}
