package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UsersDao {

    @Autowired
    private NamedParameterJdbcOperations jdbc;

    @Transactional
    public boolean create(User user) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("id_user", user.getId_user());
        params.addValue("username", user.getUsername());
        params.addValue("registered", user.getRegistered());

        return jdbc.update("INSERT INTO User (id_user, username, registered) VALUES (:id_user, :username, :registered)", params) == 1;
    }

    public boolean exists(int id_user) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM User WHERE id_user=:id_user",
                new MapSqlParameterSource("id_user", id_user), Integer.class) > 0;
    }

    public List<User> getAllUsers() {
        return jdbc.query("SELECT * FROM User", BeanPropertyRowMapper.newInstance(User.class));
    }

    public void deleteUser() {
        jdbc.getJdbcOperations().execute("DELETE FROM Image_Rating");
        jdbc.getJdbcOperations().execute("DELETE FROM Image");
        jdbc.getJdbcOperations().execute("DELETE FROM Comment_Rating");
        jdbc.getJdbcOperations().execute("DELETE FROM Comment");
        jdbc.getJdbcOperations().execute("DELETE FROM User");
    }
}
