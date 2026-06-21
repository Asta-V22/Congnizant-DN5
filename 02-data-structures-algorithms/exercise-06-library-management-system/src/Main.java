import model.Book;
import service.LibraryService;

/**
 * Demonstrates the Library Management System with linear and binary search.
 */
public class Main {

    public static void main(String[] args) {
        LibraryService library = new LibraryService();

        // Build the catalog
        library.addBook(new Book(1, "The Great Gatsby",                 "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "To Kill a Mockingbird",            "Harper Lee"));
        library.addBook(new Book(3, "1984",                             "George Orwell"));
        library.addBook(new Book(4, "Pride and Prejudice",              "Jane Austen"));
        library.addBook(new Book(5, "The Catcher in the Rye",           "J.D. Salinger"));
        library.addBook(new Book(6, "Brave New World",                  "Aldous Huxley"));
        library.addBook(new Book(7, "The Alchemist",                    "Paulo Coelho"));
        library.addBook(new Book(8, "Harry Potter and the Philosopher's Stone", "J.K. Rowling"));

        // --- Linear Search ---
        System.out.println("=== Linear Search (Unsorted Catalog) ===");

        String search1 = "1984";
        Book found1 = library.linearSearchByTitle(search1);
        System.out.println("  Searching: '" + search1 + "'");
        System.out.println("  Result: " + (found1 != null ? found1 : "Not found"));

        String search2 = "The Lord of the Rings";
        Book found2 = library.linearSearchByTitle(search2);
        System.out.println("\n  Searching: '" + search2 + "'");
        System.out.println("  Result: " + (found2 != null ? found2 : "Not found"));

        // --- Binary Search ---
        System.out.println("\n=== Binary Search (Sorted Catalog) ===");
        Book[] sorted = library.getSortedByTitle();

        System.out.println("  Sorted catalog:");
        for (Book book : sorted) {
            System.out.println("    " + book);
        }

        String search3 = "Pride and Prejudice";
        Book found3 = library.binarySearchByTitle(sorted, search3);
        System.out.println("\n  Searching: '" + search3 + "'");
        System.out.println("  Result: " + (found3 != null ? found3 : "Not found"));

        String search4 = "The Hobbit";
        Book found4 = library.binarySearchByTitle(sorted, search4);
        System.out.println("\n  Searching: '" + search4 + "'");
        System.out.println("  Result: " + (found4 != null ? found4 : "Not found"));

        // --- Comparison ---
        int n = sorted.length;
        System.out.println("\n=== When to Use Each Algorithm ===");
        System.out.println("  Catalog size: " + n + " books");
        System.out.println("  Linear Search: O(n) — works on unsorted data, simple to implement.");
        System.out.println("  Binary Search: O(log n) — much faster, but requires sorted data.");
        System.out.println();
        System.out.println("  Use Linear Search when:");
        System.out.println("    - The catalog is small.");
        System.out.println("    - Books are added/removed frequently (sorting cost too high).");
        System.out.println("  Use Binary Search when:");
        System.out.println("    - The catalog is large and relatively stable.");
        System.out.println("    - Multiple searches are performed after each sort.");
    }
}
