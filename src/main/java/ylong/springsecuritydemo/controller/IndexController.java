package ylong.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cyl
 * @description: TODO 登陆接口
 * @date: 2024/3/14 18:49
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
