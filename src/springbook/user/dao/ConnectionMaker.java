package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by graham on 2016. 3. 3..
 */
public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException;
}
