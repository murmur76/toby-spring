package springbook.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import springbook.user.dao.UserDao;
import springbook.user.sqlservice.OxmSqlService;
import springbook.user.sqlservice.SqlMapConfig;
import springbook.user.sqlservice.SqlService;
import springbook.user.sqlservice.UserSqlMapConfig;

/**
 * Created by graham on 2016. 3. 24..
 */
@Configuration
public class SqlServiceContext {

    @Bean
    public SqlMapConfig sqlMapConfig() {
        return new UserSqlMapConfig();
    }

    @Bean
    public SqlService sqlService() {
        OxmSqlService sqlService = new OxmSqlService();
        sqlService.setUnmarshaller(unmarshaller());
        sqlService.setSqlmap(this.sqlMapConfig().getSqlMapResource());
        return sqlService;
    }

    public Unmarshaller unmarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("springbook.user.sqlservice.jaxb");
        return marshaller;
    }

}
