package com.example.demo;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TestClientFeignServiceFallBackFactory implements FallbackFactory<TestClient> {
    @Override
    public TestClient create(Throwable cause) {
        cause.printStackTrace();
        return new TestClientFeignServiceFallBackFactoryImpl();
    }

    static class TestClientFeignServiceFallBackFactoryImpl implements TestClient {

        @Override
        public String test() {
            return "fail";
        }
    }
}
