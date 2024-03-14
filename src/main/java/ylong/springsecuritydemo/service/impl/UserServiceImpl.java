package ylong.springsecuritydemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ylong.springsecuritydemo.config.DBUserDetailsManager;
import ylong.springsecuritydemo.entity.User;
import ylong.springsecuritydemo.mapper.UserMapper;
import ylong.springsecuritydemo.service.UserService;

/**
 * @author: cyl
 * @description: TODO 用户实现类
 * @date: 2024/3/14 20:13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private DBUserDetailsManager dbUserDetailsManager;

    @Override
    public void saveUserDetails(User user) {
        UserDetails userDetail = org.springframework.security.core.userdetails.User
                .withDefaultPasswordEncoder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        dbUserDetailsManager.createUser(userDetail);
    }
}
