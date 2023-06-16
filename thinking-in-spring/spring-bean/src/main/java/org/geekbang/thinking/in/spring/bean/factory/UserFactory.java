package org.geekbang.thinking.in.spring.bean.factory;

import org.geekbang.thinking.in.spring.ioc.overview.domain.User;

/**
 * {@link org.geekbang.thinking.in.spring.ioc.overview.domain.User} 工厂类
 * @author kzp
 * @create 2023-06-04 17:25
 */
public interface UserFactory {

    default public User createUser(){
        return User.createUser();
    }
}
