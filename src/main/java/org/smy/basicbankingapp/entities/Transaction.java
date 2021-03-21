package org.smy.basicbankingapp.entities;

import javax.persistence.*;

@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_generator")
    @SequenceGenerator(name = "transaction_generator", sequenceName = "transaction_seq", allocationSize = 1)
    private long transactionId;
    private String nameTransferFrom;
    private String nameTransferTo;
    private long customerIdFrom;
    private long customerIdTo;
    private double transferAmount;

    public Transaction() {

    }

    public Transaction(String nameTransferFrom, String nameTransferTo, long customerIdFrom, long customerIdTo, double transferAmount) {
        this.nameTransferFrom = nameTransferFrom;
        this.nameTransferTo = nameTransferTo;
        this.customerIdFrom = customerIdFrom;
        this.customerIdTo = customerIdTo;
        this.transferAmount = transferAmount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getNameTransferFrom() {
        return nameTransferFrom;
    }

    public void setNameTransferFrom(String nameTransferFrom) {
        this.nameTransferFrom = nameTransferFrom;
    }

    public String getNameTransferTo() {
        return nameTransferTo;
    }

    public void setNameTransferTo(String nameTransferTo) {
        this.nameTransferTo = nameTransferTo;
    }

    public long getCustomerIdFrom() {
        return customerIdFrom;
    }

    public void setCustomerIdFrom(long customerIdFrom) {
        this.customerIdFrom = customerIdFrom;
    }

    public long getCustomerIdTo() {
        return customerIdTo;
    }

    public void setCustomerIdTo(long customerIdTo) {
        this.customerIdTo = customerIdTo;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }
}
