package springbook.user;

import org.gjt.mm.mysql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import springbook.user.service.UserService;
import springbook.user.test.UserServiceTest;

import javax.sql.DataSource;

@Configuration
@Profile("test")
public class TestAppContext {
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setDriverClass(Driver.class);
        ds.setUrl("jdbc:mysql://localhost/springbook?characterEncoding=UTF-8");
        ds.setUsername("spring");
        ds.setPassword("book");
        return ds;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    @Bean
    public UserService testUserService() {
        return new UserServiceTest.TestUserServiceImpl();
    }
}