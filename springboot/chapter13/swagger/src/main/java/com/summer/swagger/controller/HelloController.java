package com.summer.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Renp
 * @Date: 2022/05/16 22:14
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello world";
    }
}
