package service;


import dbConfig.DatabaseUtil;
import model.Category;
import model.Product;


import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryServiceImpl  implements InventoryService{

    @Override
    public void addProduct(Product product) {
//   String sql = "INSERT INTO product (barcode,name,price,category,quantity) VALUES ("1bc23","Java Book",34, "Books",50);
        String sql = """
                INSERT INTO product
                 (barcode,name,price,category,quantity)
                VALUES (?,?,?,?,?)
                """;
        //Try with resource
        try( Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstms = conn.prepareStatement(sql)) {

            pstms.setString(1,product.getBarcode());
            pstms.setString(2,product.getName());
            pstms.setBigDecimal(3,product.getPrice());
            pstms.setString(4,product.getCategory().name());
            pstms.setInt(5,product.getQuantity());
           int numRow =  pstms.executeUpdate();
            System.out.println("A product added to database , number of rows: " + numRow);

        }catch (Exception e) {
            System.out.println("Error while adding product "+e.getMessage());
        }
    }

    @Override
    public void removeProduct(String barcode) {
String sql ="DELETE FROM product WHERE barcode= ? ";
 try( Connection conn = DatabaseUtil.getConnection();
 PreparedStatement pstmt = conn.prepareStatement(sql)) {
     pstmt.setString(1, barcode);
     pstmt.executeUpdate();

 } catch (SQLException e) {
     System.out.println("Error while deleting product "+ e.getMessage());
 }
    }

    @Override
    public void updateProduct(String barcode, Product product) {
        String sql = "UPDATE product SET name=? , price =? , category=? ,quantity =? WHERE barcode =? ";
        try( Connection conn = DatabaseUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1,product.getName());
        pstmt.setBigDecimal(2,product.getPrice());
        pstmt.setString(3,product.getCategory().name());
        pstmt.setInt(4,product.getQuantity());
        pstmt.setString(5,barcode);
        pstmt.executeUpdate();
            System.out.println("Successfully update product.");
        } catch (SQLException e) {
            System.out.println("Error while updating product "+e.getMessage());
        }

    }

    @Override
    public List<Product> showProducts() {
        List<Product> productList = new ArrayList<Product>();
        String sql = "SELECT * FROM product ";
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs =  pstmt.executeQuery()

        ) {
       while (rs.next()) {
        String barcode =    rs.getString("barcode");
        String name = rs.getString("name");
           BigDecimal price = rs.getBigDecimal("price");
           Category category = Category.valueOf(rs.getString("category"));
           int quantity = rs.getInt("quantity");
           Product product = new Product(barcode,name,price,category,quantity);
           productList.add(product);
       }
        } catch (SQLException e) {
            System.out.println("Error while reading products "+ e.getMessage());
        }
        return productList;
    }
}
