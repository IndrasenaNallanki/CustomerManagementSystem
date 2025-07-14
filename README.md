# Customer Management System

A **console-based** Java application using **JDBC** and **MySQL** to manage customers and their orders.

---

## 🚀 Tech Stack
- 🇯🇵 Java 8+  
- 🔗 **JDBC (Java Database Connectivity)** – the standard API in Java for interacting with relational databases like MySQL—it allows your application to connect, query, and manipulate data using SQL commands :contentReference[oaicite:1]{index=1}  
- 🐬 **MySQL 8.x** – a widely used open-source relational database system designed for efficiency and scalability :contentReference[oaicite:2]{index=2}  
- ✅ No frameworks—pure Java + database (no Spring, Hibernate, or other abstraction layers)

---

## 📂 Project Structure

customer/
├── DBConnection.java # Handles JDBC setup and DB connections
├── Customer.java # Customer data model (POJO)
├── Order.java # Order data model (POJO)
├── CustomerDAO.java # CRUD operations for Customer
├── OrderDAO.java # CRUD operations for Order
├── InputHelper.java # Validates console input (name, email, phone, amount)
└── Main.java # Menu-driven application logic
