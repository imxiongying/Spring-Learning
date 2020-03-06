package me.xiongying.springlearning.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class TestEventPublisherAware implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void sendMsg(String msg) {
        System.out.println("发生消息:" + msg);
        publisher.publishEvent(new TestEvent(this, msg));
    }
}
