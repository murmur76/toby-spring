package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by graham on 2016. 3. 3..
 */
public class DUserDao extends UserDao {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        // D 사 DB connection 생성 코드
        return null;
    }
}
