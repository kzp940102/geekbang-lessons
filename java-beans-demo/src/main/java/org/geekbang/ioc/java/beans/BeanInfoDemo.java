package org.geekbang.ioc.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * {@link java.beans.BeanInfo} 示例
 * @author kzp
 * @create 2023-05-07 17:54
 */
public class BeanInfoDemo {
    public static void main(String[] args) throws IntrospectionException {
        //stopClass参数可以排除Object的getClass
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            //System.out.println(propertyDescriptor);
            //PropertyDescriptor 允许添加属性编辑器 -PropertyEditor
            // GUI -> text(string) -> PropertyType
            //name -> String
            //age -> Integer
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyName = propertyDescriptor.getName();
            if("age".equals(propertyName)){ //为 "age"字段/属性添加PropertyEditor
                //String -> Integer
//                Integer.valueOf("");
                propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                //propertyDescriptor.createPropertyEditor();
            }
        });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}
