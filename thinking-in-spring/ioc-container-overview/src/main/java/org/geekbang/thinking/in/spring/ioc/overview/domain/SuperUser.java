package org.geekbang.thinking.in.spring.ioc.overview.domain;

import org.geekbang.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * 超级用户
 * @author kzp
 * @create 2023-05-12 00:06
 */
@Super
public class SuperUser extends User{

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
