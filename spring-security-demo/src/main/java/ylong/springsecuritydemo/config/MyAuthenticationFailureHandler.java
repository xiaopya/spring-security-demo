package ylong.springsecuritydemo.config;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author: cyl
 * @description: TODO
 * @date: 2024/3/15 20:04
 */
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        String localizedMessage = exception.getLocalizedMessage(); // 获取异常信息

        HashMap<Object, Object> result = new HashMap<>();
        result.put("code",-1);
        result.put("message",localizedMessage);

        // 讲结果对象转换成json字符串
        String jsonString = JSON.toJSONString(result);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(jsonString);
    }
}
