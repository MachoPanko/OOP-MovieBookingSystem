package model.classes;
import controller.PricingController;
import model.enums.TransactionType;

import java.util.ArrayList;

public class Transaction {
    private int transactionID;
    private double totalPrice;
    private ArrayList<PricingController> ticketPrice;
    private String date;
    private TransactionType transactionType;

    public Transaction(int transactionID,
                       double totalPrice,
                       String date,
                       TransactionType transactionType,
                       ArrayList<PricingController> ticketPrice){
        this.transactionID = transactionID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.transactionType = transactionType;
    }

    public ArrayList<PricingController> getTicketPrice() {
        return ticketPrice;
    }
    public void setTicketPrice(ArrayList<PricingController> ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public int getTransactionID() {
        return transactionID;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public String getDate() {
        return date;
    }
    public TransactionType getTransactionType() {
        return transactionType;
    }
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", totalPrice=" + totalPrice +
                ", ticketPrice=" + ticketPrice +
                ", date='" + date + '\'' +
                ", transactionType=" + transactionType +
                '}';
    }
}
