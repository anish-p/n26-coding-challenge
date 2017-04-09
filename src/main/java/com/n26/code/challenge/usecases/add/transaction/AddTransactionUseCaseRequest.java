package com.n26.code.challenge.usecases.add.transaction;

import com.n26.code.challenge.usecases.UseCaseRequest;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class AddTransactionUseCaseRequest implements UseCaseRequest {

    @NotNull
    @NotEmpty
    public Double amount;

    @NotNull
    @NotEmpty
    public Long timestamp;

    @Override
    public String toString() {
        return "Transaction : {" +
                "Amount: " + this.amount +
                "Timestamp: " + this.timestamp +
                "}";
    }
}
