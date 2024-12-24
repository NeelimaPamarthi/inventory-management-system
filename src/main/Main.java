package main;

import model.Inventory;
import model.Product;
import service.InventoryService;
import utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try(Connection connection = DBUtils.getConnection()){
            InventoryService service = new InventoryService();
            service.loadInventoryFromDB(connection);

            Scanner scanner = new Scanner(System.in);
            while(true){
                System.out.println("\n\nInventory Management System");
                System.out.println("1. Add Product");
                System.out.println("2. Update Product");
                System.out.println("3. Display Inventory");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        System.out.print("Enter Product Name: ");
                        String name = scanner.next();
                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        Product product = new Product(0, name, quantity, price);
                        service.addProductToDB(connection, product);
                        break;

                    case 2:
                        System.out.print("Enter Product ID: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter New Quantity: ");
                        quantity = scanner.nextInt();
                        System.out.print("Enter New Price: ");
                        price = scanner.nextDouble();
                        Product product2 = service.inventory.getProductById(id);
                        service.updateInventoryInDB(connection, id, quantity, price, product2);
                        break;

                    case 3:
                        service.displayInventory();
                        break;

                    case 4:
                        DBUtils.closeResources(connection);
                        System.out.print("Existing...");
                        break;
                    default:
                        System.out.print("Invalid choice. Please try again.");
                }
                if(choice == 4)
                    break;
            }
            scanner.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
