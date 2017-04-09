package com.n26.code.challenge.entities;

import java.sql.Timestamp;

public abstract class TransactionEntity extends Entity {

    public abstract Double getAmount();

    public abstract Long getTimestamp();

    public abstract Timestamp getCreatedTimestamp();

    public abstract Timestamp getLastModifiedTimestamp();

    public interface Builder {

        Builder amount(Double amount);

        Builder timestamp(Long timestamp);

        Builder createdTimestamp(Timestamp createdTimestamp);

        Builder lastModifiedTimestamp(Timestamp lastModifiedTimestamp);

        TransactionEntity build();
    }
}
