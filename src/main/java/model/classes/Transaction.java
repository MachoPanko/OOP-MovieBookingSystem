package model.classes;
import controller.PricingController;
import model.enums.TransactionType;
import java.util.HashMap;

import java.util.ArrayList;

public class Transaction {
    private int transactionID;
    private double totalPrice;
    private String date;
    private TransactionType transactionType;
    private ArrayList<ReceiptItem> receipts;

    public Transaction(int transactionID,
                       double totalPrice,
                       String date,
                       ArrayList<ReceiptItem> receipts){
        this.transactionID = transactionID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.transactionType = transactionType;
        this.receipts = receipts;
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

    public ArrayList<ReceiptItem> getReceipts() {
        return receipts;
    }

    public void setReceipts(ArrayList<ReceiptItem> receipts) {
        this.receipts = receipts;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    public void printReceipt(){
        int eCounter=0;
        int sCounter=0;
        int aCounter=0;
        for(ReceiptItem r : receipts){
            if(r.getTicketType() == "elderly"){
                eCounter++;
            } else if (r.getTicketType() == "adult") {
                aCounter++;
            }
            else{
                sCounter++;
            }
        }


    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", totalPrice=" + totalPrice +
                ", date='" + date + '\'' +
                ", transactionType=" + transactionType +
                '}';
    }
}
