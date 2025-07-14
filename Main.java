package customer;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerDAO cdao = new CustomerDAO();
        OrderDAO odao = new OrderDAO();

        while (true) {
            System.out.println("\n--- Customer Management System ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View All Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Add Order");
            System.out.println("6. View Orders by Customer");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int ch = Integer.parseInt(sc.nextLine());

            try {
                switch (ch) {
                case 1:
                    String name = InputHelper.readName("Name: ");
                    String email = InputHelper.readEmail("Email: ");
                    String phone = InputHelper.readPhone("Phone: ");
                    String address = InputHelper.readNonEmpty("Address: ");
                    cdao.addCustomer(new Customer(0, name, email, phone, address));
                    System.out.println("Customer added.");
                    break;

                    case 2:
                        List<Customer> cs = cdao.getAllCustomers();
                        cs.forEach(c -> System.out.println(
                            c.getId() + " | " + c.getName() + " | " + c.getEmail() + " | " + c.getPhone() + " | " + c.getAddress()
                        ));
                        break;
                    case 3:
                        System.out.print("Customer ID to update: ");
                        int uid = Integer.parseInt(sc.nextLine());
                        Customer uc = cdao.getCustomerById(uid);
                        if (uc == null) { System.out.println("Not found."); break; }
                        System.out.print("Name ("+uc.getName()+"): "); name = sc.nextLine();
                        System.out.print("Email ("+uc.getEmail()+"): "); email = sc.nextLine();
                        System.out.print("Phone ("+uc.getPhone()+"): "); phone = sc.nextLine();
                        System.out.print("Address ("+uc.getAddress()+"): "); address = sc.nextLine();
                        cdao.updateCustomer(new Customer(uid,
                        		name.isEmpty() ? uc.getName() : name,
                            		email.isEmpty() ? uc.getEmail() : email,
                            		phone.isEmpty() ? uc.getPhone() : phone,
                            		address.isEmpty() ? uc.getAddress() : address
                        ));
                        System.out.println("Customer updated.");
                        break;
                    case 4:
                        System.out.print("Customer ID to delete: ");
                        if (cdao.deleteCustomer(Integer.parseInt(sc.nextLine()))) {
                            System.out.println("Deleted.");
                        } else {
                            System.out.println("Not found.");
                        }
                        break;
                    case 5:
                        int cid = InputHelper.readPositiveInt("Customer ID: ");
                        // Check if customer exists before proceeding
                        Customer cust = cdao.getCustomerById(cid);
                        if (cust == null) {
                            System.out.println("⚠️ Customer ID " + cid + " not found. Add the customer first.");
                            break;
                        }
                    
                        String prod = InputHelper.readNonEmpty("Product Name: ");
                        double amt = InputHelper.readPositiveInt("Amount: ");

                        System.out.print("Order Date (yyyy-MM-dd): ");
                        try {
                            Date od = Date.valueOf(sc.nextLine().trim());
                            odao.addOrder(new Order(0, cid, prod, amt, od));
                            System.out.println("Order added successfully.");
                        } catch (IllegalArgumentException ex) {
                            System.out.println("⚠️ Invalid date format. Use yyyy-MM-dd.");
                        }                   

                        break;                    
                    case 6:
                        System.out.print("Customer ID: ");
                        cid = Integer.parseInt(sc.nextLine());
                        List<Order> os = odao.getOrdersByCustomerId(cid);
                        os.forEach(o -> System.out.println(
                            o.getOrderId() + " | " + o.getProduct() + " | " + o.getAmount() + " | " + o.getOrderDate()
                        ));
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option.");
                }
            } catch (SQLException e) {
                System.err.println("DB error: " + e.getMessage());
            }
        }
    }
}
