package ylong.springsecuritydemo.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author: cyl
 * @description: TODO
 * @date: 2024/3/15 19:51
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Object principal = authentication.getPrincipal(); // 获取用户身份信息

        HashMap<Object, Object> result = new HashMap<>();
        result.put("code",0);
        result.put("message","登录成功");
        result.put("data",principal);

        // 讲结果对象转换成json字符串
        String jsonString = JSON.toJSONString(result);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(jsonString);
    }
}
