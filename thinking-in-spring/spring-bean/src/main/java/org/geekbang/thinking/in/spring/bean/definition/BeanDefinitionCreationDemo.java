package org.geekbang.thinking.in.spring.bean.definition;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition} 构建示例
 * @author kzp
 * @create 2023-05-17 22:50
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        //1.通过 BeanDefinitionBuilder 构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        // 通过属性设置
        beanDefinitionBuilder.addPropertyValue("id",1);
        beanDefinitionBuilder.addPropertyValue("name","kzp");
        //获取 BeanDefinition 实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //BeanDefinition并非Bean终态,可以自定义修改

        //2. 通过 AbstractBeanDefinition 以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        //通过MutablePropertyValues批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        /*propertyValues.addPropertyValue("id",1);
        propertyValues.addPropertyValue("name","kzp");*/
        propertyValues.add("id",1).add("name","kzp");
        //通过 set MutablePropertyValues批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
