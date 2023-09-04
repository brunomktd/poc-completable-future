package com.example.app.integrations.web4;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${api.name.web4}", url = "${api.url.web4}", configuration = Web4ClientConfiguration.class)
public interface Web4Client {

    @GetMapping(path = "/web4")
    public String getApiWeb4();
}
