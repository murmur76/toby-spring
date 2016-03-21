package springbook.user.service;

import org.springframework.transaction.annotation.Transactional;
import springbook.user.domain.User;

/**
 * Created by graham on 2016. 3. 14..
 */
public interface UserService {
    @Transactional
    void add(User user);

    @Transactional
    void upgradeLevels();
}
