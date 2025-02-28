package model;


import java.sql.Timestamp;

public class Bill {
    private int billId;
    private int bookingId;
    private double totalFare;
    private double discount;
    private double finalAmount;
    private Timestamp generatedAt;

    public int getBillId() { return billId; }
    public void setBillId(int billId) { this.billId = billId; }

    public int getBookingId() { return bookingId; }
    public void setBookingId(int bookingId) { this.bookingId = bookingId; }

    public double getTotalFare() { return totalFare; }
    public void setTotalFare(double totalFare) { this.totalFare = totalFare; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getFinalAmount() { return finalAmount; }
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; }

    public Timestamp getGeneratedAt() { return generatedAt; }
    public void setGeneratedAt(Timestamp generatedAt) { this.generatedAt = generatedAt; }
}
