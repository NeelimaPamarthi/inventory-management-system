# Inventory Management System

## Project Description
The **Inventory Management System** is a Java-based application that uses an SQL database to manage and track inventory. The application provides functionality to:

- Add new products to the inventory.
- Update existing product details (quantity and price).
- Display the current inventory.

The system follows a modular file structure, leveraging core Java concepts such as classes, objects, and JDBC for database interactions.

---

## File Structure
```
InventoryManagementSystem/
├── src/
│   ├── model/
│   │   ├── Product.java         # Represents the Product entity.
│   │   ├── Inventory.java       # Manages the list of products.
│   ├── service/
│   │   ├── InventoryService.java # Contains business logic and database operations.
│   ├── utils/
│   │   ├── DBUtils.java         # Handles database connection.
│   ├── main/
│   │   ├── Main.java            # Entry point of the application.
│   └── data/
│       ├── schema.sql           # SQL script to initialize the database.
```

---

## Features
1. **Add Product**: Adds a new product to the inventory.
2. **Update Product**: Updates the quantity and price of an existing product.
3. **Display Inventory**: Lists all products with their details (ID, Name, Quantity, Price).

---

## Setup Instructions

### Prerequisites
- Java Development Kit (JDK) 8 or above.
- MySQL database server.
- MySQL Connector/J library.

### Steps
1. **Database Setup**:
   - Import the `schema.sql` file into your MySQL server to create the required database and table.
     ```bash
     mysql -u <username> -p < schema.sql
     ```
   - Update the `DBUtils.java` file with your MySQL credentials:
     ```java
     private static final String DB_URL = "jdbc:mysql://localhost:3306/inventory_db";
     private static final String DB_USER = "<your-username>";
     private static final String DB_PASSWORD = "<your-password>";
     ```

2. **Download MySQL Connector**:
   - Download the MySQL Connector/J `.jar` file from the [MySQL official site](https://dev.mysql.com/downloads/connector/j/).
   - Place it in your classpath or `lib/` folder.

3. **Compile and Run**:
   - Navigate to the `src/` folder.
   - Compile the project:
     ```bash
     javac -cp .:../lib/mysql-connector-java-X.X.XX.jar main/Main.java
     ```
   - Run the application:
     ```bash
     java -cp .:../lib/mysql-connector-java-X.X.XX.jar main.Main
     ```

---

## Usage
1. Launch the application.
2. Select one of the available options:
   - `1`: Add a new product.
   - `2`: Update an existing product.
   - `3`: Display all products in the inventory.
   - `4`: Exit the application.
3. Follow the on-screen instructions to perform the chosen operation.

---

## Example
### Adding a Product
```
Enter Product Name: Pen
Enter Quantity: 100
Enter Price: 2.5
Product added successfully.
```

### Displaying Inventory
```
ID         Name            Quantity      Price
-------------------------------------------------------
1          Pen             100           2.50
```

---

## Technologies Used
- **Java**: Core programming language.
- **MySQL**: Database to store inventory data.
- **JDBC**: For database connectivity.

---

## Future Enhancements
- Implement a user authentication system.
- Add support for multiple inventory categories.
- Provide detailed reports on inventory status.
- Create a graphical user interface (GUI).

---
