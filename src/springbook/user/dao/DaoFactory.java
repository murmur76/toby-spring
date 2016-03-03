package springbook.user.dao;

/**
 * Created by graham on 2016. 3. 3..
 */
public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(new DConnectionMaker());
    }
}
