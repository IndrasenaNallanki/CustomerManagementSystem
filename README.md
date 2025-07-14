# Customer Management System

A **console-based** Java application using **JDBC** and **MySQL** to manage customers and their orders.

---

## 🚀 Tech Stack
- 🇯🇵 **Java 8+**  
- 🔗 **JDBC (Java Database Connectivity)** – the standard Java API for interacting with relational databases ([JDBC Best Practices](https://www.javaguides.net/2018/06/guide-to-jdbc-best-practices.html)) 
- 🐬 **MySQL 8.x** – open-source relational database known for performance and reliability  
- ✅ **No frameworks** – pure Java; no Spring, Hibernate, or other abstraction layers

---

## 📂 Project Structure

customer/
-  DBConnection.java # Manages JDBC setup and DB connections
-  Customer.java # Customer data model (POJO)
-  rder.java # Order data model (POJO)
-  CustomerDAO.java # CRUD operations for Customer
-  OrderDAO.java # CRUD operations for Order
-  InputHelper.java # Console input validation (name, email, phone, amount, date)
-  Main.java # Menu-driven application and CLI logic

---

## 📌 Features

- ✅ **Customer CRUD** – Add, view, update, and delete customer records  
- ✅ **Order Management** – Place and view orders linked to existing customers  
- ✅ **Input Validation** – Ensures valid name, email, 10-digit phone, positive amount, and date format  
- ✅ **Referential Integrity** – Maintained via foreign key associations with cascade delete  
- ✅ **Clean Architecture** – Separation of concerns using DAO pattern and helper utilities

---

## 🛠️ Setup Instructions

## 1. Add the MySQL JDBC driver
- Download mysql-connector-j-8.x.x.jar from MySQL site

- In Eclipse: Project ▶️ Properties ▶️ Java Build Path ▶️ Libraries ▶️ Add External JAR
## 2. Create the database schema
## Execute in MySQL
CREATE DATABASE customerdb;
USE customerdb;

- CREATE TABLE customers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100) UNIQUE,
  phone VARCHAR(20),
  address VARCHAR(200)
);

- CREATE TABLE orders (
  order_id INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT,
  product VARCHAR(100),
  amount DECIMAL(10,2),
  order_date DATE,
  FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);
## Update credentials in DBConnection.java
- private static final String URL = "jdbc:mysql://localhost:3306/customerdb";
- private static final String USER = "root";
- private static final String PASS = "<your_password>";
## Run the app
- In IDE: Run Main.java as Java Application
## 🎮 Sample Usage
--- Customer Management System ---
1. Add Customer
2. View All Customers
...

- Choose an option: 1
Name: Ram Kumar
Email: ram@example.com
Phone: 7993668789
Address: 123 MG Road
✅ Customer added.

- Choose an option: 5
Customer ID: 1
Product Name: Laptop
Amount: 45000
Order Date (yyyy-MM-dd): 2025-08-01
✅ Order added successfully.


