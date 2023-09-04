package com.example.app.integrations.web2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${api.name.web2}", url = "${api.url.web2}", configuration = Web2ClientConfiguration.class)
public interface Web2Client {

    @GetMapping(path = "/web2")
    public String getApiWeb2();
}
