package springbook.user.dao;

/**
 * Created by graham on 2016. 3. 3..
 */
public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    /* ConnectionMaker 구현 클래스를 선정하고 생성하는 코드의 중복

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    */

    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
