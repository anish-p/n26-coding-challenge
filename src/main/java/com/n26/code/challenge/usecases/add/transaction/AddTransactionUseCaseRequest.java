package com.n26.code.challenge.usecases.add.transaction;

import com.n26.code.challenge.usecases.UseCaseRequest;

public class AddTransactionUseCaseRequest implements UseCaseRequest {

    public Double amount;

    public Long timestamp;

    @Override
    public String toString() {
        return "Transaction : {" +
                "Amount: " + this.amount +
                "Timestamp: " + this.timestamp +
                "}";
    }
}
