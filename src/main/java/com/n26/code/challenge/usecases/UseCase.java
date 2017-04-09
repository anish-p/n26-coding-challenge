package com.n26.code.challenge.usecases;

public interface UseCase<T extends UseCaseRequest, R extends UseCaseResponse> {
    R execute(T useCaseRequest);
}
