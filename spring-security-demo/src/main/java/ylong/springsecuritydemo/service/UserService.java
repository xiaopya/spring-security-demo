package ylong.springsecuritydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ylong.springsecuritydemo.entity.User;

public interface UserService extends IService<User> {
    void saveUserDetails(User user);
}
