package com.novqigarrix.java.database.model;

public class ProductTransactionModel {

    private ProductModel product;

    private TransactionModel transaction;

    public ProductTransactionModel(ProductModel product, TransactionModel transaction) {
        this.product = product;
        this.transaction = transaction;
    }

    public ProductModel getProduct() {
        return product;
    }

    public TransactionModel getTransaction() {
        return transaction;
    }

}
