package com.n26.code.challenge.usecases.add.transaction;

import com.n26.code.challenge.usecases.UseCaseRequest;

import javax.validation.constraints.NotNull;

public class AddTransactionUseCaseRequest implements UseCaseRequest {

    @NotNull
    public Double amount;

    @NotNull
    public Long timestamp;

    @Override
    public String toString() {
        return "Transaction : {" +
                "Amount: " + this.amount +
                "Timestamp: " + this.timestamp +
                "}";
    }
}
