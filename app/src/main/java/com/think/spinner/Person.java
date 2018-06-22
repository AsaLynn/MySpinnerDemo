package com.think.spinner;

/**
 * Created by think on 2018/1/7.
 */

public class Person {

    private String name;
    private String city;
    public Person() {
    }

    public Person(String name,String city) {
        super();
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
