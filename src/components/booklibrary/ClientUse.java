package components.booklibrary;

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
        int maxRating = 5;
        Book hungerGames = new Book("The Hunger Games", "Suzanne Collins",
                maxRating);
        Book acotar = new Book("A Court of Thorns and Roses", "SJM", 4);
        shelf.addBook(hungerGames);
        shelf.addBook(acotar);
        shelf.getBooksByRating(5);
    }
}
