package me.xiongying.springlearning.event;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {

    private String msg;

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

}
