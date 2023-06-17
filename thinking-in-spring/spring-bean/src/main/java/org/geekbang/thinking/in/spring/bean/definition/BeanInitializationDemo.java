package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Bean 初始化 Demo
 * @author kangzhipeng
 * @create 2023-06-17 18:08
 */
@Configuration //Configuration Class
public class BeanInitializationDemo {

    public static void main(String[] args) {
        //创建 BeanFact ory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class(配置类)
        applicationContext.register(BeanInitializationDemo.class);
        //启动Spring 应用上下文
        applicationContext.refresh();
        //依赖查找 UserFactory
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        //关闭Spring 应用上下文
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
