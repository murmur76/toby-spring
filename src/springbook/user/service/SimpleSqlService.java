package springbook.user.service;

import java.util.Map;

/**
 * Created by graham on 2016. 3. 24..
 */
public class SimpleSqlService implements SqlService {
    private Map<String, String> sqlMap;

    public void setSqlMap(Map<String, String> sqlMap) {
        this.sqlMap = sqlMap;
    }

    public String getSql(String key) throws SqlRetrievalFailureException {
        String sql = sqlMap.get(key);
        if (sql == null) throw new SqlRetrievalFailureException(key + "에 대한 SQL을 찾을 수 없습니다.");
        else return sql;
    }
}
