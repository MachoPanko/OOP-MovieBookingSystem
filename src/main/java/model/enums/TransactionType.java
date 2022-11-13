package model.enums;

import model.classes.Transaction;

/**
 * Enumeration of type of transaction
 */
public enum TransactionType {
    DEBITCARD("DEBITCARD"),
    CREDITCARD("CREDITCARD"),
    CASH("CASH");

    private String transactionType;

    /**
     * A TransactionType constructor
     * @param transactionType string, invariants unchecked
     */
    TransactionType(String transactionType) {
    }

    /**
     * Converts string choice to TransactionType
     * @param choice string, invariants unchecked
     * @return TransactionType
     */
    public static TransactionType getTransactionType(String choice) {
        return switch(choice.toUpperCase()){
            case "DEBITCARD" -> DEBITCARD;
            case "CREDITCARD" -> CREDITCARD;
            case "CASH" -> CASH;
            default -> null;
        };
    }
}
