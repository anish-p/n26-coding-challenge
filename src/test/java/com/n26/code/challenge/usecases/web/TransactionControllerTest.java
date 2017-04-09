package com.n26.code.challenge.usecases.web;

import com.n26.code.challenge.gateway.transaction.inmemory.TransactionRepository;
import com.n26.code.challenge.usecases.add.transaction.AddTransactionUseCase;
import com.n26.code.challenge.usecases.add.transaction.AddTransactionUseCaseRequest;
import com.n26.code.challenge.usecases.add.transaction.AddTransactionUseCaseResponse;
import com.n26.code.challenge.usecases.transaction.summary.TransactionSummaryUseCase;
import com.n26.code.challenge.usecases.transaction.summary.TransactionSummaryUseCaseRequest;
import com.n26.code.challenge.usecases.transaction.summary.TransactionSummaryUseCaseResponse;
import com.n26.code.challenge.web.TransactionController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    private AddTransactionUseCase addTransactionUseCase;

    @MockBean
    private TransactionSummaryUseCase transactionSummaryUseCase;

    @Test
    public void givenTransaction_whenSavedSuccessfully_ThenReturnHttp201() throws Exception {
        when(this.addTransactionUseCase
                .execute(any(AddTransactionUseCaseRequest.class)))
                .thenReturn(getValidAddTransactionUseCaseResponse());
        this.mockMvc
                .perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content(getFullOrderString("src/test/resources/__files/transaction.json")))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void givenInvalidTransaction_whenRequestFired_ThenReturnHttp500() throws Exception {
        when(this.addTransactionUseCase
                .execute(any(AddTransactionUseCaseRequest.class)))
                .thenReturn(getValidAddTransactionUseCaseResponse());
        this.mockMvc
                .perform(post("/transactions")
                        .contentType(APPLICATION_JSON)
                        .content(getFullOrderString("src/test/resources/__files/invalid-transaction.json")))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError());
    }

    @Test
    public void whenTransactionSummaryRequested_ThenReturnHttp201() throws Exception {
        when(this.transactionSummaryUseCase
                .execute(any(TransactionSummaryUseCaseRequest.class)))
                .thenReturn(getValidTransactionSummaryUseCaseResponse());
        this.mockMvc
                .perform(get("/statistics")
                        .contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private AddTransactionUseCaseResponse getValidAddTransactionUseCaseResponse() {
        return new AddTransactionUseCaseResponse(true);
    }

    private TransactionSummaryUseCaseResponse getValidTransactionSummaryUseCaseResponse() {
        TransactionSummaryUseCaseResponse response = new TransactionSummaryUseCaseResponse();
        response.sum = 100.0;
        response.avg = 10.0;
        response.max = 10.0;
        response.min = 10.0;
        response.count = 10l;
        return response;
    }

    private String getFullOrderString(String filePath) throws Exception {
        return FileCopyUtils.copyToString(
                new BufferedReader(new InputStreamReader(
                        new FileInputStream(new File(filePath)))));
    }
}
