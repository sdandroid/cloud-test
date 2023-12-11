package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "USER-TEST"
        ,fallbackFactory = TestClientFeignServiceFallBackFactory.class)
public interface TestClient {
    @GetMapping("/index")
    String test();
}
