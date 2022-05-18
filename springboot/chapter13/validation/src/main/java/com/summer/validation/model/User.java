package com.summer.validation.model;

import javax.validation.constraints.*;

/**
 * @Author: Renp
 * @Date: 2022/05/17 23:27
 */
public class User {
    private Long id;

//    @NotNull(message = "{user.name.notNull}")
    @NotBlank(message = "{user.name.notNull}")
    @Size(min = 3, max = 7)
    private String name;

    @DecimalMin(value = "1", message = "{user.age.minSize}")
    @DecimalMax(value = "200")
    private Integer age;

    @NotNull
    private String adress;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
