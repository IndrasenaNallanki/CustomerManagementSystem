# Customer Management System

A **console-based** Java application using **JDBC** and **MySQL** to manage customers and their orders.

---

## 🚀 Tech Stack
- 🇯🇵 Java 8+  
- 🔗 JDBC (Java Database Connectivity) – the standard Java API for connecting to relational databases like MySQL :contentReference[oaicite:1]{index=1}  
- 🐬 MySQL 8.x  
- ✅ No frameworks — pure Java + database

---

## 📂 Project Structure
customer/
├── DBConnection.java # JDBC connection logic
├── Customer.java # Customer model
├── Order.java # Order model
├── CustomerDAO.java # CRUD for customers
├── OrderDAO.java # CRUD for orders
├── InputHelper.java # Validates console input (name, email, phone, amount...)
└── Main.java # Console UI menu and app flow

---

## 🛠️ Setup Instructions

### 1. Clone the repo
```bash
git clone https://github.com/your-username/customer-management-system.git
cd customer-management-system
##Create MySQL schema
CREATE DATABASE customerdb;
USE customerdb;

CREATE TABLE customers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  phone VARCHAR(20),
  address VARCHAR(200)
);
CREATE TABLE orders (
  order_id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT,
  product VARCHAR(100),
  amount DECIMAL(10,2),
  order_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);
## Set database credentials
--Update DBConnection.java:
private static final String URL = "jdbc:mysql://localhost:3306/customerdb";
private static final String USER = "root";
private static final String PASS = "<your_mysql_password>";
##Add the JDBC driver
(mysql-connector-j-8.x.x.jar) to your classpath using your IDE
##Run the application:
Execute the customer.Main class and navigate through the menu to manage customers and orders.
##🎯 Features & Highlights
•	Customer CRUD: Add, View, Update, Delete
•	Order Management: Create orders linked to existing customers
•	Input Validation: Validates name, email, phone (10 digits), amount (positive), date (yyyy MM dd)
•	Referential Integrity: Enforced via foreign key with cascading delete
•	Clean Architecture: DAO layer, Models, Input Helper, Main UI
## Sample Usage
1. Add Customer
   Name: Ram Kumar
   Email: ram@example.com
   Phone: 7993668789
   Address: 123 Main Street
   → Customer added.

5. Add Order
   Customer ID: 1
   Product Name: Laptop
   Amount: 45000
   Order Date (yyyy-MM-dd): 2025-08-01
   → Order added successfully.

