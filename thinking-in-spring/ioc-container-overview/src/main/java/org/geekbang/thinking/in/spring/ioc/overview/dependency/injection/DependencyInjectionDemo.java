package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.geekbang.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 * @author kzp
 * @create 2023-05-13 00:21
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        //配置 XML配置文件
        //启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository",UserRepository.class);
        //System.out.println(userRepository.getUsers());

        //依赖注入
        System.out.println(userRepository.getBeanFactory());

//        System.out.println(userRepository.getBeanFactory() == beanFactory); //false

        //获取到SuperUser
       /* ObjectFactory<User> objectFactory = userRepository.getUserObjectFactory();
        System.out.println(objectFactory.getObject());*/
        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject() == beanFactory); //true

        //依赖查找（错误）
        //System.out.println(beanFactory.getBean(BeanFactory.class));
    }
}
