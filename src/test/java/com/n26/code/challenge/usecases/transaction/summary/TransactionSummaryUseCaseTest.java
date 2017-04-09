package com.n26.code.challenge.usecases.transaction.summary;

import com.n26.code.challenge.gateway.TransactionGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionSummaryUseCaseTest {

    @Mock
    private TransactionGateway transactionGateway;

    @InjectMocks
    private TransactionSummaryUseCase transactionSummaryUseCase;

    @Test
    public void givenValidTimestamp_thenReturnSuccessfulResponse() {
        when(this.transactionGateway
                .findAll(any(Timestamp.class)))
                .thenReturn(getValidTransactionAmounts());
        final TransactionSummaryUseCaseResponse useCaseResponse = this.transactionSummaryUseCase
                .execute(getValidUseCaseRequest());
        assertThat(useCaseResponse.max, is(40.5));
        assertThat(useCaseResponse.sum, is(111.0));
        assertThat(useCaseResponse.avg, is(22.2));
        assertThat(useCaseResponse.min, is(10.5));
        assertThat(useCaseResponse.count, is(5l));
    }

    private TransactionSummaryUseCaseRequest getValidUseCaseRequest() {
        return new TransactionSummaryUseCaseRequest(new Timestamp(System.currentTimeMillis()));
    }

    private List<Double> getValidTransactionAmounts() {
        return Arrays.asList(10.5, 15.4, 20.1, 40.5, 24.5);
    }
}
