package model;

/**
 * Represents a product on the e-commerce platform.
 * Supports searching by productId, productName, or category.
 */
public class Product implements Comparable<Product> {

    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    /**
     * Natural ordering by product name (case-insensitive) to support binary search.
     */
    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }

    @Override
    public String toString() {
        return String.format("Product[id=%d, name='%s', category='%s']",
                productId, productName, category);
    }
}
