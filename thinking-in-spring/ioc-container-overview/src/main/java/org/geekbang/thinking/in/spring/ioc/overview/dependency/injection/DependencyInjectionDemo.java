package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
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
    }
}
