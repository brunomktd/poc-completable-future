package com.example.app.controller;

import com.example.app.integrations.web1.Web1Client;
import com.example.app.integrations.web2.Web2Client;
import com.example.app.integrations.web3.Web3Client;
import com.example.app.integrations.web4.Web4Client;
import com.example.app.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/app")
public class ApiController {

    @Autowired
    private Web1Client web1Client;

    @Autowired
    private Web2Client web2Client;

    @Autowired
    private Web3Client web3Client;

    @Autowired
    private Web4Client web4Client;


    @GetMapping
    public String getApi(){
        long start = System.currentTimeMillis();

        CompletableFuture<Object> future = new CompletableFuture<>();

        CompletableFuture<Void> apiWeb1 = future.thenRunAsync(() -> web1Client.getApiWeb1());
        CompletableFuture<Void> apiWeb2 = future.thenRunAsync(() -> web2Client.getApiWeb2());
        CompletableFuture<Void> apiWeb3 = future.thenRunAsync(() -> web3Client.getApiWeb3());
        CompletableFuture<Void> apiWeb4 = future.thenRunAsync(() -> web4Client.getApiWeb4());

//        CompletableFuture<Void> apiWeb1 = CompletableFuture.runAsync(() -> web1Client.getApiWeb1());
//        CompletableFuture<Void> apiWeb2 = CompletableFuture.runAsync(() -> web2Client.getApiWeb2());
//        CompletableFuture<Void> apiWeb3 = CompletableFuture.runAsync(() -> web3Client.getApiWeb3());
//        CompletableFuture<Void> apiWeb4 = CompletableFuture.runAsync(() -> web4Client.getApiWeb4());

        CompletableFuture.allOf(apiWeb1, apiWeb2, apiWeb3, apiWeb4);

        long end = System.currentTimeMillis();
        return String.format("App duração: %s/s para %s, %s, %s, %s", ((end - start) / 1000), apiWeb1, apiWeb2, apiWeb3, apiWeb4);
    }

}
