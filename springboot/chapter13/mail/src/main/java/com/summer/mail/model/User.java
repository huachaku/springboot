package com.summer.mail.model;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: Renp
 * @Date: 2022/05/15 23:26
 */
public class User {
    private String username;
    private String company;
    private String position;
    private Double salary;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
