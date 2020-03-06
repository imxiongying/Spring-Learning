package me.xiongying.springlearning.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TestAsyncThreadPoolEventListener implements ApplicationListener<TestEvent> {

    @Async("customThreadPoolExecutor")
    @Override
    public void onApplicationEvent(TestEvent event) {
        // 异步收到监听消息,通过自定义线程池
        System.out.println("线程[" + Thread.currentThread().getName() + "]" +  "异步(自定义线程池) 收到消息:" + event.getMsg());
    }
}
