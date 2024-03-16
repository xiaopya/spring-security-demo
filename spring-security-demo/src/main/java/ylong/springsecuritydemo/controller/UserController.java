package ylong.springsecuritydemo.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ylong.springsecuritydemo.entity.User;
import ylong.springsecuritydemo.service.UserService;

import java.util.List;

/**
 * @author: cyl
 * @description: TODO
 * @date: 2024/3/14 20:15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/list")
    public List<User> getUserList() {
        return userService.list();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user){
        userService.saveUserDetails(user);
    }
}
