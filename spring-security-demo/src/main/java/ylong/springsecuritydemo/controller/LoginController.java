package ylong.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cyl
 * @description: TODO
 * @date: 2024/3/15 19:00
 */

@RestController
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
