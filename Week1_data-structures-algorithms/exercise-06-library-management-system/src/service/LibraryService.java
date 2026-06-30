package service;

import model.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Library catalog service supporting both linear and binary search on books.
 *
 * Linear Search: Works on the unsorted catalog — O(n).
 * Binary Search: Works on a sorted copy of the catalog — O(log n).
 */
public class LibraryService {

    private final List<Book> catalog = new ArrayList<>();

    public void addBook(Book book) {
        catalog.add(book);
    }

    /**
     * Linear search for a book by title (case-insensitive).
     * Scans every book in the catalog sequentially.
     *
     * Time: O(n) | Works on unsorted data.
     */
    public Book linearSearchByTitle(String title) {
        for (Book book : catalog) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Binary search for a book by title (case-insensitive).
     * Requires the array to be sorted by title beforehand.
     *
     * Time: O(log n) | Requires sorted data.
     */
    public Book binarySearchByTitle(Book[] sortedBooks, String title) {
        int low = 0;
        int high = sortedBooks.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sortedBooks[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) {
                return sortedBooks[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    /**
     * Returns a sorted copy of the catalog (by title) for binary search.
     * Sorting cost: O(n log n)
     */
    public Book[] getSortedByTitle() {
        Book[] sorted = catalog.toArray(new Book[0]);
        Arrays.sort(sorted, Comparator.comparing(
                book -> book.getTitle().toLowerCase()));
        return sorted;
    }

    public List<Book> getCatalog() {
        return catalog;
    }
}
