package com.n26.code.challenge.web;

import com.n26.code.challenge.usecases.add.transaction.AddTransactionUseCase;
import com.n26.code.challenge.usecases.add.transaction.AddTransactionUseCaseRequest;
import com.n26.code.challenge.usecases.add.transaction.AddTransactionUseCaseResponse;
import com.n26.code.challenge.usecases.transaction.summary.TransactionSummaryUseCase;
import com.n26.code.challenge.usecases.transaction.summary.TransactionSummaryUseCaseRequest;
import com.n26.code.challenge.usecases.transaction.summary.TransactionSummaryUseCaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.sql.Timestamp;

@RestController
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Autowired
    private AddTransactionUseCase addTransactionUseCase;
    @Autowired
    private TransactionSummaryUseCase transactionSummaryUseCase;

    @RequestMapping(value = "/transactions", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> createTransaction(@RequestBody final AddTransactionUseCaseRequest addTransactionUseCaseRequest) {
        LOGGER.info("Request:" + addTransactionUseCaseRequest);
        final AddTransactionUseCaseResponse addTransactionUseCaseResponse = addTransactionUseCase
                .execute(addTransactionUseCaseRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionSummaryUseCaseResponse> statistics() {

        LOGGER.info("Fetching the transactions which happened over the last 60 seconds");
        final TransactionSummaryUseCaseResponse transactionSummaryUseCaseResponse = this.transactionSummaryUseCase
                .execute(new TransactionSummaryUseCaseRequest(new Timestamp(System.currentTimeMillis() - (60 * 1000))));
        if (null == transactionSummaryUseCaseResponse)
            return new ResponseEntity(HttpStatus.OK);

        return new ResponseEntity<TransactionSummaryUseCaseResponse>(transactionSummaryUseCaseResponse, HttpStatus.OK);
    }
}
