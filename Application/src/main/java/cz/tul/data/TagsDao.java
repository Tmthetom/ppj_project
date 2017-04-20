package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TagsDao {
    @Autowired
    private NamedParameterJdbcOperations jdbc;

    @Transactional
    public boolean create(Tag tag) {

        MapSqlParameterSource params = new MapSqlParameterSource();

        params.addValue("name", tag.getName());

        return jdbc.update("INSERT INTO Tag (name) " +
                "VALUES (:name)", params) == 1;
    }

    public boolean exists(String name) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM Tag WHERE name=:name",
                new MapSqlParameterSource("name", name), Integer.class) > 0;
    }

    public List<User> getAllTags() {
        return jdbc.query("SELECT * FROM Tag", BeanPropertyRowMapper.newInstance(User.class));
    }

    public void deleteTag() {
        jdbc.getJdbcOperations().execute("DELETE FROM Image_Tag");
        jdbc.getJdbcOperations().execute("DELETE FROM Tag");
    }
}
