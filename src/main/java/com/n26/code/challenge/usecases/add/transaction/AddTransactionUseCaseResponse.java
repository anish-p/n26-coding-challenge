package com.n26.code.challenge.usecases.add.transaction;

import com.n26.code.challenge.usecases.UseCaseResponse;

public class AddTransactionUseCaseResponse implements UseCaseResponse {

    public boolean isSuccess = false;

    public AddTransactionUseCaseResponse(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
}
