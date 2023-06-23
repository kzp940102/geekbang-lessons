package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单体 Bean 注册示例
 * @author kangzhipeng
 * @create 2023-06-23 08:49
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //创建一个外部UserFactory对象
        UserFactory userFactory = new DefaultUserFactory();
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        //注册外部单例对象
        beanFactory.registerSingleton("userFactory",userFactory);
        //启动Spring 应用上下文
        applicationContext.refresh();
        //通过依赖查找的方式来获取UserFactory
        UserFactory userFactoryByLookup = beanFactory.getBean("userFactory",UserFactory.class);
        System.out.println("userFactory == userFactoryByLookup :" +(userFactory == userFactoryByLookup));
        //关闭Spring 应用上下文
        applicationContext.close();
    }
}
