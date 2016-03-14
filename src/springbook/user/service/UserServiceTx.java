package springbook.user.service;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import springbook.user.domain.User;

/**
 * Created by graham on 2016. 3. 14..
 */
public class UserServiceTx implements UserService {
    UserService userService;
    PlatformTransactionManager txManager;

    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setUserService(UserService userService) {

        this.userService = userService;
    }

    public void add(User user) {
        userService.add(user);
    }

    public void upgradeLevels() {
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());

        try {
            userService.upgradeLevels();
            txManager.commit(status);
        } catch (RuntimeException e) {
            txManager.rollback(status);
            throw e;
        }
    }
}
