package service;

import model.Inventory;
import model.Product;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InventoryService {
    public Inventory inventory;

    public InventoryService(){
        this.inventory = new Inventory();
    }

    public void loadInventoryFromDB(Connection connection) throws SQLException{
        String query = "SELECT * FROM products";
        try(PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                Product product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));
                inventory.addProduct(product);
            }
        }
    }

    public void addProductToDB(Connection connection, Product product) throws SQLException{
        String insertSQL = "INSERT INTO products (name, quantity, price) values (?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(insertSQL, PreparedStatement.RETURN_GENERATED_KEYS)){
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                try(ResultSet generatedKey = stmt.getGeneratedKeys()){
                    if(generatedKey.next()){
                        product.setId(generatedKey.getInt(1));
                        inventory.addProduct(product);
                        System.out.print("Product added successfully.");
                    }else{
                        System.out.print("Failed to retrieve generated Id for the product");
                    }
                }
            }else{
                System.out.print("Product addition to DB failed.");
            }
        }
    }

    public void updateInventoryInDB(Connection connection, int id, int quantity, double price, Product product) throws SQLException{
        String updateSQL = "UPDATE products SET quantity = ?, price = ? WHERE id = ?";
        try(PreparedStatement stmt = connection.prepareStatement(updateSQL)){
            stmt.setInt(1, quantity);
            stmt.setDouble(2, price);
            stmt.setInt(3, id);
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                product.setQuantity(quantity);
                product.setPrice(price);
                System.out.print("Product details are updated in DB and object");
            }else{
                System.out.print("No product found with given details");
            }
        }
    }

    public void displayInventory(){
        List<Product> products = inventory.getProducts();
        products.forEach(System.out::println);
        System.out.print("All the products are listed");
    }
}
