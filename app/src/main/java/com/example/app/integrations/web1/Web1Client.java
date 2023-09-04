package com.example.app.integrations.web1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${api.name.web1}", url = "${api.url.web1}", configuration = Web1ClientConfiguration.class)
public interface Web1Client {

    @GetMapping(path = "/web1")
    public String getApiWeb1();
}
