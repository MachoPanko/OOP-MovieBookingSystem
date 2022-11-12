package model.classes;
import controller.PricingController;
import model.enums.TransactionType;

import java.io.Serializable;

public class Transaction implements Serializable  {
    private final String transactionID;
    private final double totalPrice;
    private final String date;
    private final TransactionType transactionType;

    public Transaction(String transactionID,
                       double totalPrice,
                       String date,
                       TransactionType transactionType){
        this.transactionID = transactionID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.transactionType = transactionType;
    }
    public String getTransactionID() {
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

//    public void printReceipt(){
//        int eCounter=0;
//        int sCounter=0;
//        int aCounter=0;
//        for(ReceiptItem r : receipts){
//            if(r.getTicketType() == "elderly"){
//                eCounter++;
//            } else if (r.getTicketType() == "adult") {
//                aCounter++;
//            }
//            else{
//                sCounter++;
//            }
//        }
//
//
//    }

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
