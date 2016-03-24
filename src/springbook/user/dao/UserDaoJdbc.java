package springbook.user.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import springbook.user.domain.Level;
import springbook.user.domain.User;
import springbook.user.sqlservice.SqlService;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Repository
public class UserDaoJdbc implements UserDao {
    private JdbcTemplate jdbcTemplate;
    @Autowired private SqlService sqlService;

    private DataSource dataSource;
    private RowMapper<User> userMapper = new RowMapper<User>() {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getString("id"), rs.getString("name"), rs.getString("password"), Level.valueOf(rs.getInt("level")), rs.getInt("login"), rs.getInt("recommend"));
        }
    };

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    public void add(final User user) {
        jdbcTemplate.update(this.sqlService.getSql("addSql"), new Object[]{ user.getId(), user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend() });
    }

    public void update(final User user) {
        jdbcTemplate.update(this.sqlService.getSql("updateSql"), new Object[]{ user.getName(), user.getPassword(), user.getLevel().intValue(), user.getLogin(), user.getRecommend(), user.getId() });
    }


    public User get(final String id) {
        return jdbcTemplate.queryForObject(this.sqlService.getSql("getSql"),
                new Object[] { id }, userMapper);
    }

    public List<User> getAll() {
        return jdbcTemplate.query(this.sqlService.getSql("getAllSql"), userMapper);
    }

    public void deleteAll() {
        jdbcTemplate.update(this.sqlService.getSql("deleteAllSql"));
    }

    public int getCount() {
        return jdbcTemplate.queryForObject(this.sqlService.getSql("getCountSql"), Integer.class);
    }

}
