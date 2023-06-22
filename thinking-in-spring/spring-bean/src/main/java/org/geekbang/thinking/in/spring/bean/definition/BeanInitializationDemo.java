package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.geekbang.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
        System.out.println("Spring 应用上下文已启动...");
        //依赖查找 UserFactory
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("Spring 应用上下文准备关闭...");
        //关闭Spring 应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭...");
    }

    @Bean(initMethod = "initUserFactory",destroyMethod = "doDestroy")
    @Lazy(value = false) //true表示延迟加载
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }
}
