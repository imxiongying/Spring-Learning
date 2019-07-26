package me.xiongying.springlearning;

import me.xiongying.springlearning.bean.TestService;
import me.xiongying.springlearning.event.TestEventPublisherAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext acx = SpringApplication.run(Main.class, args);
    }

//    public static void main(String[] args) {
//        ConfigurableApplicationContext acx = SpringApplication.run(Main.class, args);
//
//        BeanFactory beanFactory =  acx.getBeanFactory();
//
//        System.out.println("beanFactory.name=" + beanFactory.getClass().getName());
//
//
//        TestEventPublisherAware testEventPublisherAware  =acx.getBean(TestEventPublisherAware.class);
//        testEventPublisherAware.sendMsg("这是1条测试消息");
//
//        TestService testService = acx.getBean(TestService.class);
//        testService.test();
//
//        System.out.println("------------------------spring container wait close-------------------------");
//
//        try {
//            Thread.sleep(1000  * 10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        acx.close();
//
//    }
}
