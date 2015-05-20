package lab1;

/**
 * A representation of a book.
 *
 * @author <a href="mailto:rkhatchadourian@citytech.cuny.edu">Raffi
 * Khatchadourian</a>.
 */
public class Book {

    /**
     * This book's title.
     */
    private String title;

    /**
     * True if this book is borrowed and false otherwise.
     */
    private boolean borrowed;

    /**
     * Creates a new Book.
     *
     * @param bookTitle The title of the book that will be created.
     */
    public Book(String bookTitle) {
        title = bookTitle;
        boolean borrowed;
    }

    /**
     * Marks this book as rented.
     */
    public void rented() {
        borrowed = true;
    }

    /**
     * Marks this book as not rented.
     */
    public void returned() {
        borrowed = false;
    }

    /**
     * Returns true if this book is rented, false otherwise.
     *
     * @return true if this book is rented and false otherwise.
     */
    public boolean isBorrowed() {

        return ((borrowed) ? true : false);

    }

    /**
     * Returns this book's title as a String.
     *
     * @return This book's title as a String.
     */
    public String getTitle() {
        return title;
    }

    public void Borrow() {
        borrowed = true;
    }

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.rented();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }

}
