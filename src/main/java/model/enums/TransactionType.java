package model.enums;

import model.classes.Transaction;

public enum TransactionType {
    DEBITCARD("DEBITCARD"),
    CREDITCARD("CREDITCARD"),
    CASH("CASH");

    private String transactionType;

    TransactionType(String transactionType) {
    }

    public static TransactionType getTransactionType(String choice) {
        return switch(choice.toUpperCase()){
            case "DEBITCARD" -> DEBITCARD;
            case "CREDITCARD" -> CREDITCARD;
            case "CASH" -> CASH;
            default -> null;
        };
    }
}
