package com.n26.code.challenge.usecases.add.transaction;

import com.n26.code.challenge.gateway.TransactionGateway;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddTransactionUseCaseTest {

    @Mock
    private TransactionGateway transactionGateway;

    @InjectMocks
    private AddTransactionUseCase addTransactionUseCase;
}
