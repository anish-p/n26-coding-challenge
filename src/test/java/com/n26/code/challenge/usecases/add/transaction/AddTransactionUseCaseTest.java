package com.n26.code.challenge.usecases.add.transaction;

import com.n26.code.challenge.entities.TransactionEntity;
import com.n26.code.challenge.gateway.TransactionGateway;
import com.n26.code.challenge.gateway.transaction.inmemory.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AddTransactionUseCaseTest {

    @Mock
    private TransactionGateway transactionGateway;

    @InjectMocks
    private AddTransactionUseCase addTransactionUseCase;

    @Test
    public void whenGivenValidRequest_ThenReturnSuccessfulResponse() throws Exception {
        when(this.transactionGateway
                .save(any(Transaction.class)))
                .thenReturn(getValidTransactionEntity());
        final AddTransactionUseCaseResponse addTransactionUseCaseResponse = this.addTransactionUseCase
                .execute(getValidUseCaseRequest());
        assertThat(addTransactionUseCaseResponse.isSuccess, is(true));
    }

    private TransactionEntity getValidTransactionEntity() {
        TransactionEntity transaction = new Transaction.Builder()
                .amount(100.4)
                .timestamp(1478192204010l)
                .createdTimestamp(new Timestamp(System.currentTimeMillis()))
                .lastModifiedTimestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        return transaction;
    }

    private AddTransactionUseCaseResponse getSuccessUseCaseResponse() {
        return new AddTransactionUseCaseResponse(true);
    }

    private AddTransactionUseCaseRequest getValidUseCaseRequest() {
        AddTransactionUseCaseRequest useCaseRequest = new AddTransactionUseCaseRequest();
        useCaseRequest.amount = 12.3;
        useCaseRequest.timestamp = 1478192204000l;
        return useCaseRequest;
    }
}
