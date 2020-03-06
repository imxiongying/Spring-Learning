package me.xiongying.springlearning.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池配置
 * Created by xiongying on 2020/3/6.
 */
@Component
@EnableAsync
public class CustomThreadPoolConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(CustomThreadPoolConfiguration.class);

    @Bean(name = "customThreadPoolExecutor")
    public Executor customThreadPoolExecutor() {
        ThreadFactory threadFactory = new AppNotifyDefaultThreadFactory();
        RejectedExecutionHandler rejectedExecutionHandler = new AppNotifyRejectedExecutionHandler();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(200), threadFactory, rejectedExecutionHandler);
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 50, 60L, TimeUnit.SECONDS,
//                new LinkedBlockingQueue<Runnable>(200), threadFactory, rejectedExecutionHandler);
        return threadPoolExecutor;
    }

    static class AppNotifyDefaultThreadFactory implements ThreadFactory {
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        AppNotifyDefaultThreadFactory() {
            namePrefix = "custom-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
            t.setDaemon(false);
            t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

    static class AppNotifyRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            logger.error("Task " + r.toString() + " rejected from " + e.toString());
        }
    }

}
