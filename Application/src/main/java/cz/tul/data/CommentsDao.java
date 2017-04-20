package cz.tul.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CommentsDao {

    @Autowired
    private NamedParameterJdbcOperations jdbc;

    @Transactional
    public boolean create(Comment comment) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_comment", comment.getId_comment());
        params.addValue("id_image", comment.getId_image());
        params.addValue("id_author", comment.getId_author());
        params.addValue("message", comment.getMessage());
        params.addValue("created", comment.getCreated());
        params.addValue("updated", comment.getUpdated());

        return jdbc.update("INSERT INTO Comment (id_comment, id_image, id_author, message, created, updated) " +
                "VALUES (:id_comment, :id_image, :id_author, :message, :created, :updated)", params) == 1;
    }

    public boolean exists(int id_comment) {
        return jdbc.queryForObject("SELECT COUNT(*) FROM Comment WHERE id_comment=:id_comment",
                new MapSqlParameterSource("id_comment", id_comment), Integer.class) > 0;
    }

    public List<User> getAllComments() {
        return jdbc.query("SELECT * FROM Comment", BeanPropertyRowMapper.newInstance(User.class));
    }

    public boolean update(Comment comment) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id_comment", comment.getId_comment());
        params.addValue("id_image", comment.getId_image());
        params.addValue("id_author", comment.getId_author());
        params.addValue("message", comment.getMessage());
        params.addValue("created", comment.getCreated());
        params.addValue("updated", comment.getUpdated());

        return jdbc.update("UPDATE Comment SET id_comment=:id_comment, id_image=:id_image, id_author=:id_author, message=:message, created=:created, updated=:updated WHERE id_comment=:id_comment", params) == 1;
    }

    public void deleteComments() {
        jdbc.getJdbcOperations().execute("DELETE FROM Comment_Rating");
        jdbc.getJdbcOperations().execute("DELETE FROM Comment");
    }
}
