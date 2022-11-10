package model.enums;

import model.classes.Transaction;

public enum TransactionType {
    TEST("TEST");

    TransactionType(String test) {
    }

    public static TransactionType getType() {
        return TEST;
    }
}
