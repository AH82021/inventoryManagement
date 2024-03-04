package ui;


import input.UserInputReader;
import model.Category;
import model.Product;
import service.InventoryService;
import service.InventoryServiceImpl;

import java.math.BigDecimal;
import java.util.*;

public class PosUI {
 private  final InventoryService inventoryService  ;
 private final UserInputReader userInputReader ;

    public PosUI(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        this.userInputReader = new UserInputReader();
    }

    public void showMenu(){
   while (true) {
       System.out.println("Welcome to Inventory Management System: Please choose from the following options ");
       System.out.println("1- Add Product to Inventory");
       System.out.println("2- Remove Product from Inventory");
       System.out.println("3- Update Product from Inventory");
       System.out.println("4- Display all products in Inventory");
       System.out.println("5.Exit");
       int choice = userInputReader.readInt("");
       switch (choice){
               case 1 :
               addProduct();
               break;
                case 2 :
                 removeProduct();
                break;
                case 3 :
                 updateProduct();
                    break;
                case 4 :
                    displayProduct();
                    break;
                case 5 :
                    System.out.println("Existing ... ");
                    System.exit(0);
           default:
               System.out.println("Invalid choice ,please try a number between 1 and 5 ");
       }
   }

    }

    private void displayProduct() {
        List<Product> productList = inventoryService.showProducts();

        for (Product product : productList) {
            System.out.println(product);
        }
    }

    private void updateProduct() {
        System.out.println("Update an Existing Product ");
        userInputReader.readString("");
        String barcode = userInputReader.readString("Enter barcode of the product to be updated.");
        String name = userInputReader.readString("Enter name of the product to be updated");
        BigDecimal price = userInputReader.readBigDecimal("Enter new price");
        int categoryOrdinal = userInputReader.readInt(" Enter new category number ( 0-FOOD,1-CLOTHING,2-ELECTRONICS,3-BOOKS,4-PRODUCE,5-MEAT,6-OTHERS)");
        int quantity = userInputReader.readInt("Enter new quantity");
        Category category = Category.values()[categoryOrdinal];
        Product product = new Product(barcode,name,price,category,quantity);
        inventoryService.updateProduct(barcode,product);
        System.out.println("Product with barcode "+barcode + " updated successfully ");


    }

    private void removeProduct() {
        userInputReader.readString("");
        System.out.println("Removing a Product ");

        String barcode = userInputReader.readString("Enter barcode of the product to be removed.");
        inventoryService.removeProduct(barcode);
        System.out.println("Product with barcode: "+barcode+ "removed successfully ");

    }

    private void addProduct() {

        userInputReader.readString("");
        System.out.println("Add New Product ");
        String barcode = userInputReader.readString("Enter product barcode: ");

        String name = userInputReader.readString("Enter product name : ");
        BigDecimal price = userInputReader.readBigDecimal("Enter price: ");
        int cartGoryOrdinal = userInputReader.readInt("Enter category number ( 0-FOOD,1-CLOTHING,2-ELECTRONICS,3-BOOKS,4-PRODUCE,5-MEAT,6-OTHERS)");
        Category category = Category.values()[cartGoryOrdinal];
        int quantity = userInputReader.readInt("Enter quantity for product : ");
        Product product = new Product(barcode,name,price,category,quantity);
 inventoryService.addProduct(product);
    }

    public static void main(String[] args) {
InventoryService service = new InventoryServiceImpl();
     PosUI ui = new PosUI(service);
       ui.showMenu();







    }
}
