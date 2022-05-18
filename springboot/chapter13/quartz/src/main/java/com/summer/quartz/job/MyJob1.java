package com.summer.quartz.job;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: Renp
 * @Date: 2022/05/16 20:44
 */
@Component
public class MyJob1 {

    public void sayHello(){
        System.out.println("sayHello" + new Date());
    }
}
