package com.n26.code.challenge.gateway.transaction.inmemory;

import com.n26.code.challenge.entities.TransactionEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction")
public class Transaction extends TransactionEntity implements Serializable {

    private Double amount;

    private Long timestamp;

    private Timestamp createdTimestamp;

    private Timestamp lastModifiedTimestamp;

    @Override
    public Double getAmount() {
        return this.amount;
    }

    @Override
    public Long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public Timestamp getCreatedTimestamp() {
        return this.createdTimestamp;
    }

    @Override
    public Timestamp getLastModifiedTimestamp() {
        return this.lastModifiedTimestamp;
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
