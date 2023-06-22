package org.geekbang.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean 垃圾回收（GC）示例
 * @author kangzhipeng
 * @create 2023-06-22 21:12
 *
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册 Configuration Class(配置类)
        applicationContext.register(BeanInitializationDemo.class);
        //启动Spring 应用上下文
        applicationContext.refresh();
        //关闭Spring 应用上下文
        applicationContext.close();
        Thread.sleep(5000L);
        //强制触发GC
        System.gc();
        /**
         * finalize方法不一定完全会被回调
         * 不是稳定出现的，不代表这个对象不会被回收,只是说这个方法不会被回调
         */
        Thread.sleep(5000L);
    }
}
