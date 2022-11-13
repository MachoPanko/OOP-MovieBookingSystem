package model.classes;
import controller.PricingController;
import model.enums.TransactionType;

import java.io.Serializable;

public class Transaction implements Serializable  {
    private final String transactionID;
    private final double totalPrice;
    private final String date;
    private final TransactionType transactionType;

    /**
     *
     * @param transactionID The Id of the transaction made
     * @param totalPrice The total price of all tickets booked
     * @param date The date of when the transaction is made
     * @param transactionType The type of transaction that is made
     */
    public Transaction(String transactionID,
                       double totalPrice,
                       String date,
                       TransactionType transactionType){
        this.transactionID = transactionID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.transactionType = transactionType;
    }

    /**
     * Gets the transaction id
     * @return transactionID
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Gets the total price
     * @return totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets the date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Gets the transaction type
     * @return transactionType
     */
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

    /**
     * Overrides toString
     * @return String
     */
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
