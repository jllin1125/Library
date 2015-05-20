package lab1;

/**
 * A representation of a library of books.
 *
 * @author jianlang lin,Ziying Guo
 */
public class Library {

    String library_address;
    static String library_hours = "Libraries are open daily from 9AM to 5PM";
    Book[] catalog = new Book[0];
    int numberofBooks = 0;

//List of Methods for Libraries
    public Library(String address) {
        library_address = address;
    }

    public static void printOpeningHours() {
        System.out.println(library_hours);
    }

    public void printAddress() {
        System.out.println(library_address);
    }

    //Add books to library catalog
    public void addBook(Book newbook) {
        if (numberofBooks >= 0) {
            Book[] newarray = new Book[(numberofBooks + 1)];
            System.arraycopy(catalog, 0, newarray, 0, numberofBooks);
            catalog = newarray;
        }
        catalog[numberofBooks] = newbook;
        numberofBooks++;
    }

//Check out book from catalog
    public void borrowBook(String title) {
        String string1 = title;
        if (catalog.length == 0) {
            System.out.println("Sorry, this book is not in our catalog");
        }
        for (int i = 0; i <numberofBooks ; i++) {
            if ((string1.equals(catalog[i].getTitle())) && (catalog[i].isBorrowed() == false)) {
                catalog[i].isBorrowed();
                System.out.println("You successfully borrowed " + catalog[i].getTitle());
                break;
            } else if (string1.equals(catalog[i].getTitle()) && catalog[i].isBorrowed() == true) {
                System.out.println("Sorry, this book is already borrowed.");
                break;
            } else if (string1.equals(catalog[i].getTitle()) == false) {
                System.out.println("Sorry, this book is not in our catalog");
                break;
            }
        }
    }

    //Return book to library
    public void returnBook(String title) {
        String string1 = title;
        for (int i = 0; i < catalog.length; i++) {
            if (string1.equals(catalog[i].getTitle()) && catalog[i].isBorrowed() == true) {
                catalog[i].returned();
                System.out.println("You successfully returned " + catalog[i].getTitle());
                break;
            }
        }
    }

    public void printAvailableBooks() {
        if (catalog.length > 0) {
            for (int i = 0; i < numberofBooks; i++) {
                System.out.println(catalog[i].getTitle());
            }
        } else {
            System.out.println("No books in catalog currently.");
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
