package me.xiongying.springlearning.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestEventConfiguration {

    @Bean
    public TestEventPublisherAware testEventPublisherAware() {
        return new TestEventPublisherAware();
    }

    @Bean
    public TestEventListener testEventListener() {
        return new TestEventListener();
    }
}
