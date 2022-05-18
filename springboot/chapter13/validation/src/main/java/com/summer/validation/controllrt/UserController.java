package com.summer.validation.controllrt;

import com.summer.validation.model.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: Renp
 * @Date: 2022/05/17 23:22
 */
@RestController
public class UserController {

    @PostMapping("/user")
    public void addUser(@Valid User user, BindingResult result){
        System.out.println("user = " + user);
        if (result != null && result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.getObjectName() + ":" + error.getDefaultMessage());
            }
        }
    }
}
