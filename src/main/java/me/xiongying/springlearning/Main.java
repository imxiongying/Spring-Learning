package me.xiongying.springlearning;

import me.xiongying.springlearning.bean.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext acx = SpringApplication.run(Main.class, args);
        TestService testService = acx.getBean(TestService.class);
        testService.test();

        System.out.println("------------------------spring container wait close-------------------------");

        try {
            Thread.sleep(1000  * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        acx.close();

    }
}
