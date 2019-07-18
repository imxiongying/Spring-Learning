package me.xiongying.springlearning.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

@Component
public class TestInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    public TestInstantiationAwareBeanPostProcessor() {
        System.out.println("TestInstantiationAwareBeanPostProcessor实例化");
    }

    @Nullable
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanClass.getSimpleName().equals(TestDao.class.getSimpleName())) {
            System.out.println("TestInstantiationAwareBeanPostProcessor postProcessBeforeInstantiation,beanName=" + beanName);
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (bean.getClass().getSimpleName().equals(TestDao.class.getSimpleName())) {
            System.out.println("TestInstantiationAwareBeanPostProcessor postProcessAfterInstantiation,beanName=" + beanName);
        }
        return true;
    }

    @Nullable
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (bean.getClass().getSimpleName().equals(TestDao.class.getSimpleName())) {
            System.out.println("TestInstantiationAwareBeanPostProcessor postProcessPropertyValues,beanName=" + beanName);
        }
        return pvs;
    }


}
