package components.booklibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/**
 * tests the constructors and getters.
 */
public class BooksTest {
    /**
     * tests the constructor.
     */
    @Test
    public void testConstructor() {
        Book book = new Book("bhawana's book", "bhawana", 5);
        assertEquals("bhawana's book", book.getTitle());
        assertEquals("bhawana", book.getAuthor());
        assertEquals(5, book.getRating());

    }

    /**
     * checks invalid input of 100.
     */
    @Test
    public void testInvalidRating() {
        assertThrows(IllegalArgumentException.class,
                () -> new Book("my book", "me", 100));
    }

}
