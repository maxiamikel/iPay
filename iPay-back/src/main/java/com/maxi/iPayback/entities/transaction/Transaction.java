package com.maxi.iPayback.entities.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.maxi.iPayback.entities.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "transactions")
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "sender_fk")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_fk")
    private User receiver;
    private LocalDate transactionTime;
    public Transaction() {
    }
    public Transaction(BigDecimal amount, User sender, User receiver) {
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }
    public Long getId() {
        return id;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
    public User getSender() {
        return sender;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public User getReceiver() {
        return receiver;
    }
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    public LocalDate getTransactionTime() {
        return transactionTime;
    }
    public void setTransactionTime(LocalDate transactionTime) {
        this.transactionTime = transactionTime;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
