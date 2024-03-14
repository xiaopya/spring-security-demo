package ylong.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class SpringSecurityDemoApplicationTests {

    @Test
    void contextLoads() {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

        String encodedUsername = encoder.encode("admin");
        String encodedPassword = encoder.encode("123456");

        System.out.println(encodedUsername);
        System.out.println(encodedPassword);
    }

}
