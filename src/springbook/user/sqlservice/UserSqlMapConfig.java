package springbook.user.sqlservice;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import springbook.user.dao.UserDao;

/**
 * Created by graham on 2016. 3. 31..
 */
public class UserSqlMapConfig implements SqlMapConfig {
    public Resource getSqlMapResource() {
        return new ClassPathResource("sqlmap.xml", UserDao.class);
    }
}
