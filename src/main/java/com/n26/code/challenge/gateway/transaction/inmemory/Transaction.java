package com.n26.code.challenge.gateway.transaction.inmemory;

import com.n26.code.challenge.entities.TransactionEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
public class Transaction extends TransactionEntity implements Serializable {

    private Double amount;

    private Long timestamp;

    private Timestamp createdTimestamp;

    private Timestamp lastModifiedTimestamp;

    public Transaction() {}

    public Transaction(Double amount, Long timestamp, Timestamp createdTimestamp, Timestamp lastModifiedTimestamp) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.createdTimestamp = createdTimestamp;
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    @Id
    @Override
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(name = "amount")
    @Override
    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "timestamp")
    @Override
    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Column(name = "created_timestamp")
    @Override
    public Timestamp getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Column(name = "last_modified_timestamp")
    @Override
    public Timestamp getLastModifiedTimestamp() {
        return this.lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(Timestamp lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public static class Builder implements TransactionEntity.Builder {

        private Double amount;

        private Long timestamp;

        private Timestamp createdTimestamp;

        private Timestamp lastModifiedTimestamp;

        @Override
        public TransactionEntity.Builder amount(Double amount) {
            this.amount = amount;
            return this;
        }

        @Override
        public TransactionEntity.Builder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        @Override
        public TransactionEntity.Builder createdTimestamp(Timestamp createdTimestamp) {
            this.createdTimestamp = createdTimestamp;
            return this;
        }

        @Override
        public TransactionEntity.Builder lastModifiedTimestamp(Timestamp lastModifiedTimestamp) {
            this.lastModifiedTimestamp = lastModifiedTimestamp;
            return this;
        }

        @Override
        public TransactionEntity build() {
            return new Transaction.Builder()
                    .amount(amount)
                    .timestamp(timestamp)
                    .createdTimestamp(createdTimestamp)
                    .lastModifiedTimestamp(lastModifiedTimestamp)
                    .build();
        }
    }
}
