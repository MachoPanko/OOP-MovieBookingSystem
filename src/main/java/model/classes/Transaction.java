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
    public Transaction(int transactionID, double totalPrice, String date, TransactionType transactionType, ArrayList<PricingController> ticketPrice){
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
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append("Transaction ID: "); build.append(this.getTransactionID()); build.append("\n");
        build.append("Prices: "); build.append(this.getTicketPrice()); build.append("\n");
        build.append("Total Price: "); build.append(this.getTotalPrice()); build.append("\n");
        build.append("Date: "); build.append(this.getDate()); build.append("\n");
        build.append("Transaction Type: "); build.append(this.getTransactionType().toString()); build.append("\n");
        return build.toString();
    }
}
