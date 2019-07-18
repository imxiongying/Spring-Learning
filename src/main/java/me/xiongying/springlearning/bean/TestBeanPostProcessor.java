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
        if (bean.getClass().getSimpleName().equals(TestDao.class.getSimpleName())) {
            System.out.println("TestBeanPostProcessor postProcessBeforeInitialization, beanName = " + beanName);
        }
        return bean;
    }

    @Nullable
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getSimpleName().equals(TestDao.class.getSimpleName())) {
            System.out.println("TestBeanPostProcessor postProcessAfterInitialization, beanName = " + beanName);
        }
        return bean;
    }
}
