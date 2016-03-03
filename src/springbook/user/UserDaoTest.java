package springbook.user;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

public class UserDaoTest {

    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao dao = context.getBean("userDao", UserDao.class);

        dao.deleteAll();
        assertEquals(dao.getCount(), 0);

        User user = new User("whiteship", "graham", "kang");
        dao.add(user);
        assertEquals(dao.getCount(), 1);

        User user2 = dao.get(user.getId());
        assertEquals(user.getName(), user2.getName());
        assertEquals(user.getPassword(), user2.getPassword());
    }

}
