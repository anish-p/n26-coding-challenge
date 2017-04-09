package com.n26.code.challenge.usecases.add.transaction;

import com.n26.code.challenge.gateway.TransactionGateway;
import org.mockito.InjectMocks;
import org.mockito.Mock;

//@RunWith(MockitoJUnitRunner.class)
public class AddTransactionUseCaseTest {

    @Mock
    private TransactionGateway transactionGateway;

    @InjectMocks
    private AddTransactionUseCase addTransactionUseCase;


}
