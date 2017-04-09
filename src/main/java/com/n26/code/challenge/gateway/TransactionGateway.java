package com.n26.code.challenge.gateway;

import com.n26.code.challenge.entities.TransactionEntity;

import java.sql.Timestamp;
import java.util.List;

public interface TransactionGateway {

    TransactionEntity save(TransactionEntity transaction);

    List<Double> findAll(Timestamp fromTimestamp);
}
