package com.n26.code.challenge.usecases.transaction.summary;

import com.n26.code.challenge.usecases.UseCaseRequest;

import java.sql.Timestamp;

public class TransactionSummaryUseCaseRequest implements UseCaseRequest {

    public Timestamp fromTimestamp;

    public TransactionSummaryUseCaseRequest(Timestamp fromTimestamp) {
        this.fromTimestamp = fromTimestamp;
    }
}
