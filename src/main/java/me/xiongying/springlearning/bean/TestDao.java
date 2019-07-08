package me.xiongying.springlearning.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
public class TestDao implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    public TestDao() {
        System.out.println(TestDao.class.getSimpleName() + " 实例化");
    }

    public void test() {
        System.out.println(TestDao.class.getSimpleName() + " call test()");
    }


    @Override
    public void setBeanName(String name) {
        System.out.println(TestDao.class.getSimpleName() + " setBeanName by BeanNameAware, name = " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(TestDao.class.getSimpleName() + " setBeanFactory by BeanFactoryAware, beanFactory = " + beanFactory);
    }


    @Override
    public void destroy() throws Exception {
        System.out.println(TestDao.class.getSimpleName() + " destroy by DisposableBean ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(TestDao.class.getSimpleName() + " afterPropertiesSet by InitializingBean ");
    }

    @PostConstruct
    public void postConstruct() {
        //相当于init-methed
        System.out.println(TestDao.class.getSimpleName() + " postConstruct ");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(TestDao.class.getSimpleName() + " preDestroy ");
    }
}
