package me.xiongying.springlearning.event;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class TestAsyncEventListener implements ApplicationListener<TestEvent> {

    @Async
    @Override
    public void onApplicationEvent(TestEvent event) {
        // 异步收到监听消息,默认是通过new一个新线程调用onApplicationEvent
        System.out.println("线程[" + Thread.currentThread().getName() + "]" + "异步(新建一根线程) 收到消息:" + event.getMsg());
    }
}
