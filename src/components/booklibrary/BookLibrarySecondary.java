package components.booklibrary;

/**
 * secondary class where some methods will get implimented. BookLibrarySecondary
 */
public abstract class BookLibrarySecondary implements BookLibrary {

    /**
     * returns whether or not this is empty.
     *
     * @return whether or not it is empty.
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

}
