package com.n26.code.challenge.usecases.transaction.summary;

import com.n26.code.challenge.usecases.UseCaseResponse;

public class TransactionSummaryUseCaseResponse implements UseCaseResponse {

    public Double sum;
    public Double avg;
    public Double max;
    public Double min;
    public Long count;
}
