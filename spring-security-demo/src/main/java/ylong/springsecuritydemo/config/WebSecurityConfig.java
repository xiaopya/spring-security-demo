package ylong.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author: cyl
 * @description: TODO springSecurity配置
 * @date: 2024/3/14 19:19
 */
@Configuration
// @EnableWebSecurity // 开启springSecurity的自定义注解，（springboot项目可以省略）
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 开始授权保护
        http.authorizeHttpRequests(authorize -> authorize
                        // 对所有请求开启授权保护
                        .anyRequest()
                        // 已认证的请求会被自动授权
                        .authenticated()
                )
                .formLogin(form->
                        form
                                .permitAll()
                                .successHandler(new MyAuthenticationSuccessHandler()) // 认证成功的处理
                                .failureHandler(new MyAuthenticationFailureHandler()) // 认证失败的处理
//                                .usernameParameter("myUsername") // 配置自定义表单参数 默认：username
//                                .passwordParameter("myPassword") // 配置自定义表单参数 默认：password
                )
                // 使用表单授权方式
                .formLogin(withDefaults());
                // 使用基本授权方式（浏览器自带的原始登陆方式）
                //.httpBasic(withDefaults());

        // 开启跨域
        http.cors(withDefaults());

        // TODO 先临时关闭csrf攻击防御
//        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        // 创建基于数据库的用户管理器
//        return new InMemoryUserDetailsManager();
//    }


//    @Bean
//    public UserDetailsService userDetailsService() {
//        // 创建基于内存的用户信息管理器
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        // 使用manager管理UserDetails对象
//        manager.createUser(
//                // 创建UserDetails对象，用户管理用户名、用户密码、用户角色、用户权限等内容
//                User.withDefaultPasswordEncoder().username("ylong").password("password").roles("USER").build()
//        );
//        return manager;
//    }
}
