package com.maxi.iPayback.dtos;

import java.math.BigDecimal;

public class TransactionDTO {

    private BigDecimal amount;
    private Long senderId;
    private Long reseiverId;

    public TransactionDTO() {
    }

    public TransactionDTO(BigDecimal amount, Long senderId, Long reseiverId) {
        this.amount = amount;
        this.senderId = senderId;
        this.reseiverId = reseiverId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReseiverId() {
        return reseiverId;
    }

    public void setReseiverId(Long reseiverId) {
        this.reseiverId = reseiverId;
    }

}
