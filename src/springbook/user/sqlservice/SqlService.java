package springbook.user.sqlservice;

/**
 * Created by graham on 2016. 3. 24..
 */
public interface SqlService {
    String getSql(String key) throws SqlRetrievalFailureException;
}
