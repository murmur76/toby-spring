package springbook.user.service;

import springbook.user.domain.User;

/**
 * Created by graham on 2016. 3. 14..
 */
public interface UserService {
    void add(User user);
    void upgradeLevels();
}
