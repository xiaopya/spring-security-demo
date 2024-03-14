package ylong.springsecuritydemo.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import ylong.springsecuritydemo.entity.User;
import ylong.springsecuritydemo.mapper.UserMapper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author: cyl
 * @description: TODO 初始化DBUserDetailsManager对象
 * @date: 2024/3/14 20:33
 */

@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }

    /**
     * 插入用户数据
     * @param user
     */
    @Override
    public void createUser(UserDetails user) {
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        userMapper.insert(user1);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    /**
     * 从数据库中获取用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }else {

            // 没有，先创建一个
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    true, // 账号是否启用
                    true, // 用户账号是否过期
                    true, // 用户凭证是否过期
                    true, // 用户是否锁定
                    authorities // 权限列表
            );
        }
    }
}
