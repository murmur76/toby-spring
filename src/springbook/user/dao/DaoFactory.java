package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by graham on 2016. 3. 3..
 */

@Configuration // ApplicationContext 또는 BeanFactory가 사용할 설정정보라는 표시
public class DaoFactory {
    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
