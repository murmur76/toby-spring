package springbook.user.dao;

import springbook.user.domain.User;

import java.util.List;

/**
 * Created by graham on 2016. 3. 8..
 */
public interface UserDao {
    void add(User User);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    int getCount();
}
