package model.classes;
import model.enums.TransactionType;

import java.util.ArrayList;

public class Transaction {
    private int transactionID;
    private ArrayList<Double> prices;
    private double totalPrice;
    private String date;
    private TransactionType transactionType;
    public Transaction(int transactionID, ArrayList<Double> prices, double totalPrice, String date, TransactionType transactionType){
        this.transactionID = transactionID;
        this.prices = prices;
        this.totalPrice = totalPrice;
        this.date = date;
        this.transactionType = transactionType;

    }

    public int getTransactionID() {
        return transactionID;
    }
    public ArrayList<Double> getPrices() {
        return prices;
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
    public void setPrices(ArrayList<Double> prices) {
        this.prices = prices;
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
        build.append("Prices: "); build.append(this.getPrices().toString()); build.append("\n");
        build.append("Total Price: "); build.append(this.getTotalPrice()); build.append("\n");
        build.append("Date: "); build.append(this.getDate()); build.append("\n");
        build.append("Transaction Type: "); build.append(this.getTransactionType().toString()); build.append("\n");
        return build.toString();
    }
}
