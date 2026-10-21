package components.booklibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.sequence.Sequence;

/**
 * tests kernel methods and duplicate entries.
 */
public class BookLibrary1Test {
    /**
     * checks whether library is empty.
     */
    @Test
    public void testIsEmpty() {
        BookLibrary1 library = new BookLibrary1();
        assertTrue(library.isEmpty());
    }

    /**
     * checks whether library is empty.
     */
    @Test
    public void testIsEmpty2() {
        BookLibrary1 library = new BookLibrary1();
        library.addBook(new Book("my book", "me", 5));
        assertFalse(library.isEmpty());
    }

    /**
     * reports the size of library.
     */
    @Test
    public void size() {
        BookLibrary1 library = new BookLibrary1();
        assertEquals(0, library.size());
    }

    /**
     * reports the size of library.
     */
    @Test
    public void size1() {
        BookLibrary1 library = new BookLibrary1();
        library.addBook(new Book("bhawana", "me", 5));
        library.addBook(new Book("bhawana's 2nd book", "me", 5));
        assertEquals(2, library.size());
    }

    /**
     * checks if a book was added.
     */
    @Test
    public void addBookTest() {
        BookLibrary1 library = new BookLibrary1();
        library.addBook(new Book("bhawana", "me", 5));
        assertEquals(1, library.size());
    }

    /**
     * checks if a book was added.
     */
    @Test
    public void addBookTest2() {
        BookLibrary1 library = new BookLibrary1();
        library.addBook(new Book("bhawana", "me", 5));
        library.addBook(new Book("bhawana's 2nd book", "me", 5));
        assertEquals(2, library.size());
    }

    /**
     * checks if a book was removed.
     */
    @Test
    public void removeBook() {
        BookLibrary1 library = new BookLibrary1();
        Book one = new Book("bhawana", "me", 5);
        Book two = new Book("bhawana's 2nd book", "me", 5);
        Book three = new Book("bhawana's 3nd book", "me", 5);
        library.addBook(one);
        library.addBook(two);
        library.addBook(three);

        library.removeBook(one);
        assertEquals(2, library.size());
        assertFalse(library.hasBook(one));
    }

    /**
     * checks if a book was removed.
     */
    @Test
    public void removeBook2() {
        BookLibrary1 library = new BookLibrary1();
        Book one = new Book("bhawana", "me", 5);
        Book two = new Book("bhawana's 2nd book", "me", 5);
        Book three = new Book("bhawana's 3nd book", "me", 5);
        library.addBook(one);
        library.addBook(two);
        library.addBook(three);

        library.removeBook(one);
        library.removeBook(three);
        assertEquals(1, library.size());
        assertFalse(library.hasBook(one));
        assertFalse(library.hasBook(three));
    }

    /**
     * makes sure the same book does not get added twice. the same book matches
     * in title and author.
     */
    @Test
    public void duplicateBookTest() {
        BookLibrary1 library = new BookLibrary1();
        library.addBook(new Book("Dune", "Frank Herbert", 4));
        assertThrows(IllegalArgumentException.class,
                () -> library.addBook(new Book("Dune", "Frank Herbert", 3)));
    }

    /**
     * clears the library.
     */
    @Test
    public void clearTest() {
        BookLibrary1 library = new BookLibrary1();
        Book one = new Book("bhawana", "me", 5);
        Book two = new Book("bhawana's 2nd book", "me", 5);
        Book three = new Book("bhawana's 3nd book", "me", 5);
        library.addBook(one);
        library.addBook(two);
        library.addBook(three);
        library.clear();
        assertEquals(0, library.size());
    }

    /**
     * checks if library has a book.
     */
    @Test
    public void hasBookTest() {
        BookLibrary1 library = new BookLibrary1();
        Book one = new Book("bhawana", "me", 5);
        Book two = new Book("bhawana's 2nd book", "me", 5);
        Book three = new Book("bhawana's 3nd book", "me", 5);
        library.addBook(one);
        library.addBook(two);
        library.addBook(three);
        assertTrue(library.hasBook(one));
    }

    /**
     * checks if library has a book.
     */
    @Test
    public void hasBookTest2() {
        BookLibrary1 library = new BookLibrary1();
        Book one = new Book("bhawana", "me", 5);
        Book two = new Book("bhawana's 2nd book", "me", 5);
        Book three = new Book("bhawana's 3nd book", "me", 5);
        library.addBook(one);
        library.addBook(two);
        library.addBook(three);
        library.removeBook(one);
        assertFalse(library.hasBook(one));
    }

    /**
     * gets a book by rating.
     */
    @Test
    public void getBooksByRatingTest() {
        BookLibrary1 library = new BookLibrary1();
        Book one = new Book("bhawana", "me", 3);
        Book two = new Book("bhawana's 2nd book", "me", 5);
        Book three = new Book("bhawana's 3nd book", "me", 5);
        library.addBook(one);
        library.addBook(two);
        library.addBook(three);

        Sequence<Book> fiveStarBooks = library.getBooksByRating(5);

        assertEquals(2, fiveStarBooks.length());
        assertEquals("bhawana's 2nd book", fiveStarBooks.entry(0).getTitle());
        assertEquals("bhawana's 3nd book", fiveStarBooks.entry(1).getTitle());
    }

    /**
     * gets a book by rating.
     */
    @Test
    public void getBooksByRatingTest2() {
        BookLibrary1 library = new BookLibrary1();
        Book one = new Book("bhawana", "me", 3);
        Book two = new Book("bhawana's 2nd book", "me", 2);
        Book three = new Book("bhawana's 3nd book", "me", 1);
        library.addBook(one);
        library.addBook(two);
        library.addBook(three);

        Sequence<Book> fiveStarBooks = library.getBooksByRating(5);

        assertEquals(0, fiveStarBooks.length());
    }

    /**
     * alledgely does not remove a book that does not exist.
     */
    @Test
    public void removeMissingBookTest() {
        BookLibrary1 library = new BookLibrary1();
        Book missing = new Book("Dune", "Frank Herbert", 4);
        assertThrows(IllegalArgumentException.class,
                () -> library.removeBook(missing));
    }

    /**
     * alledgely makes sure you can't look up an invalid rating.
     */
    @Test
    public void getBooksByInvalidRatingTest() {
        BookLibrary1 library = new BookLibrary1();
        assertThrows(IllegalArgumentException.class,
                () -> library.getBooksByRating(-1));
    }

}
