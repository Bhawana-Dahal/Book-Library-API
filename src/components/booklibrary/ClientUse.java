package components.booklibrary;

import components.sequence.Sequence;

/**
 * The comments used from the clients perspective.
 */
public class ClientUse {
    /**
     * main.
     *
     * @param args
     *            the String of arguments
     */
    public static void main(String[] args) {
        //Checkstyle is bugging out.
        BookLibrary shelf = new BookLibrary1();
        Book hungerGames = new Book("The Hunger Games", "Suzanne Collins",
                Book.MAX_RATING);
        Book acotar = new Book("A Court of Thorns and Roses", "SJM", 4);
        System.out.println("Empty Shelf? - " + shelf.isEmpty());
        Book naturals = new Book("The Naturals", "Jennifer Lynn Barnes",
                Book.MAX_RATING);
        shelf.addBook(hungerGames);
        shelf.addBook(acotar);
        shelf.addBook(naturals);
        System.out.println("Shelf size = " + shelf.size());

        Sequence<Book> fiveStars = shelf.getBooksByRating(Book.MAX_RATING);
        System.out.println("All 5 star reads: ");

        for (int i = 0; i < fiveStars.length(); i++) {
            System.out.println(i + 1 + ". " + fiveStars.entry(i));
        }
    }
}
