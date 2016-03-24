package springbook.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook.user.service.UserService;
import springbook.user.test.UserServiceTest;

@Configuration
public class TestAppContext {
    @Bean
    public UserService testUserService() {
        return new UserServiceTest.TestUserServiceImpl();
    }
}
