package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 * @author kzp
 * @create 2023-05-23 22:48
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        //配置 XML配置文件
        //启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        User user = beanFactory.getBean("user", User.class);
        User xiaomageUser = beanFactory.getBean("xiaomage-user", User.class);
        System.out.println("xiaomage-user 是否与 user Bean相同:" + (user == xiaomageUser));
    }
}
