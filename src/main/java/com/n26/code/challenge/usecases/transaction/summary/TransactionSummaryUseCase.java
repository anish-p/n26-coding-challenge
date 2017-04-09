package com.n26.code.challenge.usecases.transaction.summary;

import com.n26.code.challenge.gateway.TransactionGateway;
import com.n26.code.challenge.usecases.UseCase;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class TransactionSummaryUseCase implements UseCase<TransactionSummaryUseCaseRequest, TransactionSummaryUseCaseResponse> {

    private TransactionGateway transactionGateway;

    @Override
    public TransactionSummaryUseCaseResponse execute(TransactionSummaryUseCaseRequest useCaseRequest) {
        List<Double> transactions = this.transactionGateway.findAll(useCaseRequest.fromTimestamp);
        return (transactions == null ? null : createUseCaseResponse(transactions));
    }

    public void setTransactionGateway(TransactionGateway transactionGateway) {
        this.transactionGateway = transactionGateway;
    }

    private TransactionSummaryUseCaseResponse createUseCaseResponse(List<Double> transactions) {
        TransactionSummaryUseCaseResponse response = new TransactionSummaryUseCaseResponse();
        DoubleSummaryStatistics doubleSummaryStatistics = transactions.stream()
                .mapToDouble((x) -> x)
                .summaryStatistics();
        response.sum = doubleSummaryStatistics.getSum();
        response.avg = doubleSummaryStatistics.getAverage();
        response.max = doubleSummaryStatistics.getMax();
        response.min = doubleSummaryStatistics.getMin();
        response.count = doubleSummaryStatistics.getCount();
        return response;
    }
}
