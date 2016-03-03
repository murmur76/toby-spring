package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by graham on 2016. 3. 3..
 */

public class DaoFactory {
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
