package com.n26.code.challenge.gateway.transaction.inmemory;

import com.n26.code.challenge.gateway.transaction.inmemory.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    @Query("Select t.amount FROM transaction t WHERE t.createdTimeStamp >= :fromTimestamp")
    List<Double> findAll(@Param("fromTimestamp") Timestamp fromTimestamp);
}
