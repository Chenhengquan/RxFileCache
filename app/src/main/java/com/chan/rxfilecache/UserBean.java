package com.chan.rxfilecache;

/**
 * Author : ChenHengQuan
 * Time : 2017/4/28.
 * Email : nullpointerchan@163.com
 * Desc :
 * version : v1.0
 */

public class UserBean {

    private String name;
    private int age;

    public UserBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
