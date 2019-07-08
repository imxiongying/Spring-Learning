package me.xiongying.springlearning.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class TestService implements BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {

    @Autowired
    private TestDao testDao;

    public TestService() {
        System.out.println(TestService.class.getSimpleName() + " 实例化");
    }

    public void test() {
        System.out.println(TestService.class.getSimpleName() + " call test()");
        testDao.test();
    }


    public void setTestDao(TestDao testDao) {
        System.out.println(TestService.class.getSimpleName() + " setTestDao");
        this.testDao = testDao;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(TestService.class.getSimpleName() + " setBeanName by BeanNameAware, name = " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(TestService.class.getSimpleName() + " setBeanFactory by BeanFactoryAware, beanFactory = " + beanFactory);
    }


    @Override
    public void destroy() throws Exception {
        System.out.println(TestService.class.getSimpleName() + " destroy by DisposableBean ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(TestService.class.getSimpleName() + " afterPropertiesSet by InitializingBean ");
    }

    @PostConstruct
    public void postConstruct() {
        //相当于init-methed
        System.out.println(TestService.class.getSimpleName() + " postConstruct ");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(TestService.class.getSimpleName() + " preDestroy ");
    }
}
