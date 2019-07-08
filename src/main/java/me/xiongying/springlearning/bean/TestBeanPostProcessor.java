package me.xiongying.springlearning.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

    public TestBeanPostProcessor() {
        System.out.println("TestBeanPostProcessor实例化");
    }

    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TestBeanPostProcessor postProcessBeforeInitialization, beanName = " + beanName);
        return null;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("TestBeanPostProcessor postProcessAfterInitialization, beanName = " + beanName);
        return null;
    }
}
