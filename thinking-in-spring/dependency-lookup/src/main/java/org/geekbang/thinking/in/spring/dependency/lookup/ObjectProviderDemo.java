package org.geekbang.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 通过 {@link org.springframework.beans.factory.ObjectProvider} 进行依赖查找
 * @author kangzhipeng
 * @create 2023-07-02 09:18
 */
public class ObjectProviderDemo { //@Configuration 是非必须注解
    public static void main(String[] args) {
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类ObjectProviderDemo 作为配置类(Configuration class)
        applicationContext.register(ObjectProviderDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查找
        lookupByObjectProvider(applicationContext);

        //关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public String helloWorld(){ //方法名就是Bean 名称 = "helloWorld"
        return "Hello,World";
    }

    private static void lookupByObjectProvider(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> objectProvider = applicationContext.getBeanProvider(String.class);
        System.out.println(objectProvider.getObject());
    }
}
