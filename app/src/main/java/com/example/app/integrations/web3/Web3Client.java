package com.example.app.integrations.web3;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${api.name.web3}", url = "${api.url.web3}", configuration = Web3ClientConfiguration.class)
public interface Web3Client {

    @GetMapping(path = "/web3")
    public String getApiWeb3();
}
