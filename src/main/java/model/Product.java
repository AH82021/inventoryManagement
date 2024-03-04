package model;

import java.math.BigDecimal;

public class Product  implements  Comparable<Product> {

    private String barcode;
    private String name;
    private BigDecimal price;// BigDecimal is better for monetary values
    private Category category;
    private int quantity;

    public Product() {
    }

    public Product(String barcode, String name, BigDecimal price, Category category, int quantity) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", price= $" + price +
                ", category=" + category +
                ", quantity=" + quantity +
                '}';
    }
// how should I sorted by name and quantity
    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);
    }
}
