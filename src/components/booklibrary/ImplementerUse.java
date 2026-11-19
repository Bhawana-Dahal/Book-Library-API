package components.booklibrary;

import components.map.Map;
import components.map.Map1L;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * queue of books in rating order.
 */
public class ImplementerUse implements ImplementerInterface {

    /**
     * the representation.
     */
    private Map<Integer, Sequence<Book>> rep;

    /**
     * empty queue. valid constructor?
     */
    public ImplementerUse() {
        this.rep = new Map1L<>();
    }

    /**
     * add books to this list.
     *
     * @param x
     *            book to add.
     */
    @Override
    public void enqueue(Book x) {
        int rating = x.getRating();
        if (!this.rep.hasKey(rating)) {
            this.rep.add(rating, new Sequence1L<Book>());
        }
        Sequence<Book> shelf = this.rep.value(rating);
        shelf.add(shelf.length(), x);
    }

    /**
     * removes top rated book.
     *
     * @return your top book.
     */
    @Override
    public Book dequeue() {
        if (this.length() == 0) {
            System.out.println("Queue is empty");
        }
        int r = Book.MAX_RATING;
        while (!this.rep.hasKey(r)) {
            r--; //no 5 stars? look for top in 4
        }
        Sequence<Book> shelf = this.rep.value(r);
        Book best = shelf.remove(0); //top book
        if (shelf.length() == 0) {
            this.rep.remove(r);
        }
        return best;
    }

    /**
     * how long is it.
     *
     * @return how long it is.
     */
    @Override
    public int length() {
        int total = 0;
        for (int i = 0; i < Book.MAX_RATING; i++) {
            if (this.rep.hasKey(i)) {
                total += this.rep.value(i).length();
            }
        }
        return total;
    }

    /**
     * DEMO!!!
     *
     * @param args
     */
    public static void main(String[] args) {
        ImplementerUse top = new ImplementerUse();
        top.enqueue(new Book("ACOTAR", "Sarah J Maas", 4));
        top.enqueue(new Book("Magic Tree House", "Mary Pope Osbourne", 3));
        top.enqueue(new Book("Red Rising", "Pierce Brown", 4));
        top.enqueue(new Book("Binding 13", "Chloe Walsh", Book.MAX_RATING));
        top.enqueue(new Book("The Hunger Games", "Suzanne Collins",
                Book.MAX_RATING));
        top.enqueue(new Book("Rites Of The Starling", "Deveny Perry", 3));
        int i = 1;
        while (top.length() > 0) {
            System.out.println(i + ". " + top.dequeue());
            i++;
        }

    }
}
