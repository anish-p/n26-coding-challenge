package com.n26.code.challenge.usecases.add.transaction;

import com.n26.code.challenge.entities.TransactionEntity;
import com.n26.code.challenge.gateway.TransactionGateway;
import com.n26.code.challenge.gateway.transaction.inmemory.Transaction;
import com.n26.code.challenge.usecases.UseCase;

import java.sql.Timestamp;

public class AddTransactionUseCase implements UseCase<AddTransactionUseCaseRequest, AddTransactionUseCaseResponse> {

    private TransactionGateway transactionGateway;

    @Override
    public AddTransactionUseCaseResponse execute(AddTransactionUseCaseRequest useCaseRequest) {
        TransactionEntity transaction = new Transaction.Builder()
                .amount(useCaseRequest.amount)
                .timestamp(useCaseRequest.timestamp)
                .createdTimestamp(new Timestamp(System.currentTimeMillis()))
                .lastModifiedTimestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return createUseCaseResponse(true);
    }

    public void setTransactionGateway(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    private AddTransactionUseCaseResponse createUseCaseResponse(boolean isSuccess) {
        return new AddTransactionUseCaseResponse(isSuccess);
    }
}
