package me.xiongying.springlearning.event;

import org.springframework.context.ApplicationListener;

public class TestEventListener implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent event) {
        System.out.println("收到消息:" + event.getMsg());
    }
}
