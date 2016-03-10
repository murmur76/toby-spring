package springbook.user.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;
import springbook.user.service.UserService;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static springbook.user.service.UserService.MIN_LOGIN_FOR_SILVER;
import static springbook.user.service.UserService.MIN_RECOMMEND_FOR_GOLD;

/**
 * Created by graham on 2016. 3. 10..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "/test-applicationContext.xml")
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    List<User> users;

    @Before
    public void setUp() throws Exception {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, MIN_LOGIN_FOR_SILVER - 1, 0),
                new User("joytouch", "강명성", "p2", Level.BASIC, MIN_LOGIN_FOR_SILVER, 0),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, MIN_RECOMMEND_FOR_GOLD - 1),
                new User("madnitel", "이상호", "p4", Level.SILVER, 60,  MIN_RECOMMEND_FOR_GOLD),
                new User("minkyu", "오민규", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    public void bean() throws Exception {
        assertTrue(userService != null);
    }

    @Test
    public void add() throws Exception {
        userDao.deleteAll();
        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        assertEquals(userDao.get(userWithLevel.getId()).getLevel(), userWithLevel.getLevel());
        assertEquals(userDao.get(userWithoutLevel.getId()).getLevel(), Level.BASIC);
    }

    @Test
    public void upgradeLevel() throws Exception {
        userDao.deleteAll();
        for (User user : users) userDao.add(user);
        userService.upgradeLevels();

        checkLevel(users.get(0), Level.BASIC);
        checkLevel(users.get(1), Level.SILVER);
        checkLevel(users.get(2), Level.SILVER);
        checkLevel(users.get(3), Level.GOLD);
        checkLevel(users.get(4), Level.GOLD);
    }

    private void checkLevel(User user, Level expectedLevel) {
        User updatedUser = userDao.get(user.getId());
        assertEquals(updatedUser.getLevel(), expectedLevel);
    }
}
