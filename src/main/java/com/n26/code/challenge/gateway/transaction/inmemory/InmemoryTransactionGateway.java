package com.n26.code.challenge.gateway.transaction.inmemory;

import com.n26.code.challenge.entities.TransactionEntity;
import com.n26.code.challenge.gateway.TransactionGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

public class InmemoryTransactionGateway implements TransactionGateway {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public TransactionEntity save(TransactionEntity transactionEntity) {
        return this.transactionRepository.save((Transaction) transactionEntity);
    }

    @Override
    public List<Double> findAll(Timestamp fromTimestamp) {
        return transactionRepository.findAll(fromTimestamp);
    }
}
