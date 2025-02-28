package dao;

import java.sql.*;
import model.Bill;
import model.DBConnection;

public class BillingDAO {
    public boolean generateBill(int bookingId) {
        try (Connection conn = DBConnection.getConnection()) {
            CallableStatement stmt = conn.prepareCall("{CALL GenerateBill(?)}");
            stmt.setInt(1, bookingId);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Bill getBillByBookingId(int bookingId) {
        Bill bill = null;
        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT * FROM bills WHERE booking_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, bookingId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                bill = new Bill();
                bill.setBillId(rs.getInt("bill_id"));
                bill.setBookingId(rs.getInt("booking_id"));
                bill.setTotalFare(rs.getDouble("total_fare"));
                bill.setDiscount(rs.getDouble("discount"));
                bill.setFinalAmount(rs.getDouble("final_amount"));
                bill.setGeneratedAt(rs.getTimestamp("generated_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bill;
    }
}

