package customer;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public void addOrder(Order o) throws SQLException {
        String sql = "INSERT INTO orders (customer_id, product, amount, order_date) VALUES (?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, o.getCustomerId());
            ps.setString(2, o.getProduct());
            ps.setDouble(3, o.getAmount());
            ps.setDate(4, o.getOrderDate());
            ps.executeUpdate();
        }
    }

    public List<Order> getOrdersByCustomerId(int customerId) throws SQLException {
        List<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE customer_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(
                    rs.getInt("order_id"),
                    rs.getInt("customer_id"),
                    rs.getString("product"),
                    rs.getDouble("amount"),
                    rs.getDate("order_date")
                ));
            }
        }
        return list;
    }
}

