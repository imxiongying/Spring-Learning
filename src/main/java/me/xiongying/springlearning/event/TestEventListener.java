package me.xiongying.springlearning.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class TestEventListener implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent event) {
        // 默认是同步收到事件监听的,与TestEventPublisherAware.sendMsg是同一根线程
        System.out.println("线程[" + Thread.currentThread().getName() + "]" + "同步 收到消息:" + event.getMsg());
    }
}
