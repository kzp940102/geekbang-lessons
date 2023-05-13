package org.geekbang.ioc.java.beans;

/**
 * 描述人的POJO类
 *
 * Setter/Getter方法
 * 可写方法(Writeable)/可读方法(Readable)
 * @author kzp
 * @create 2023-05-07 17:48
 */
public class Person {

    //string to string
    String name; //Property

    // string to integer
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
