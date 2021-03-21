package org.smy.basicbankingapp.entities;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
    @SequenceGenerator(name = "customer_generator", sequenceName = "customer_seq", allocationSize = 1)
    private long customerId;
    private String name;
    private String email;
    private double balance;


    public Customer() {

    }

    public Customer(String name, String email, double balance) {
        this.name = name;
        this.email = email;
        this.balance = balance;;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
