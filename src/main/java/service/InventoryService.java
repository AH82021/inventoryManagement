package service;

import model.Product;

import java.util.List;

public interface InventoryService {
    void addProduct(Product product);
    void removeProduct(String barcode);
    void updateProduct(String barcode,Product product);

    List<Product> showProducts();


}
