package springbook.user.service;

import springbook.user.dao.UserDao;

/**
 * Created by graham on 2016. 3. 10..
 */
public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
