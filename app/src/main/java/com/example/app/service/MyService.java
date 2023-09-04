package com.example.app.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Async("asyncTaskExecutor")
    public void callMethodAsync() throws InterruptedException {
//    protected CompletableFuture<String> callMethodAsync() throws InterruptedException {
        Thread.sleep(30000);
        System.out.println("Essa mensagem deverá ocorrer depois do fim");
//        return CompletableFuture.completedFuture("meuValor");
    }
}
